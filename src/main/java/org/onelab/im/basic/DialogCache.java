package org.onelab.im.basic;

import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.core.domain.Message;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by chunliangh on 14-10-21.
 */
public class DialogCache implements DialogCacheInterface {

    private Map<String,Map<String,Map>> cache = new ConcurrentHashMap<String, Map<String, Map>>();
    private final String key_info = "info";
    private final String key_msg = "msg";

    @Override
    public void cache(String group, String dialogId, Map<String, String> dialogInfo) {
        Map<String,Map> groupMap = cache.get(group);
        if (groupMap==null) {
            groupMap = new ConcurrentHashMap<String, Map>();
            cache.put(group, groupMap);
        }
        Map dialogMap = new ConcurrentHashMap<String,Object>();
        if (dialogInfo==null){
            dialogInfo = new ConcurrentHashMap<String, String>();
        }else{
            dialogInfo = new ConcurrentHashMap<String, String>(dialogInfo);
        }
        dialogMap.put(key_info,dialogInfo);
        dialogMap.put(key_msg,new ConcurrentLinkedQueue<Message>());
        groupMap.put(dialogId,dialogMap);
    }



    @Override
    public void updateDialogInfo(String group, String dialogId, Map<String, String> dialogInfo) {
        Map<String, String> info = dialogInfo(group,dialogId);
        if (info!=null){
            for (Map.Entry<String,String> entry:dialogInfo.entrySet()){
                info.put(entry.getKey(),entry.getValue());
            }
        }
    }

    @Override
    public Map<String, String> dialogInfo(String group, String dialogId) {
        Map<String,Map> groupMap = cache.get(group);
        Map<String, String> dialogInfo = null;
        if (groupMap!=null){
            Map<String,Map> dialogMap = groupMap.get(dialogId);
            if (dialogMap!=null){
                dialogInfo = new HashMap<String, String>(dialogMap.get(key_info));
            }
        }
        return dialogInfo;
    }

    @Override
    public Map<String, Map<String, String>> dialogInfoMap(String group) {
        Map<String,Map> groupMap = cache.get(group);
        Map<String,Map<String,String>> res = null;
        if (groupMap!=null){
            res = new HashMap<String, Map<String, String>>();
            for (Map.Entry<String,Map> dialogEntry:groupMap.entrySet()){
                Map<String, String> dialogInfo = (Map<String, String>) dialogEntry.getValue().get(key_info);
                res.put(dialogEntry.getKey(), new HashMap<String, String>(dialogInfo));
            }
        }
        return res;
    }

    @Override
    public List<Message> read(String group, String dialogId) {
        Map<String,Map> groupMap = cache.get(group);
        if (groupMap!=null) {
            Map dialogMap = groupMap.get(dialogId);
            if (dialogMap!=null){
                return new ArrayList<Message>((Queue<Message>) dialogMap.get(key_msg));
            }
        }
        return null;
    }

    @Override
    public void write(String group, String dialogId, Message message) {
        Message m = new Message(message);
        Map<String,Map> groupMap = cache.get(group);
        if (groupMap!=null) {
            Map dialogMap = groupMap.get(dialogId);
            if (dialogMap!=null){
                Queue<Message> messageQueue = (Queue<Message>) dialogMap.get(key_msg);
                if (m.getTime()==null){
                    m.setTime(new Date());
                }
                messageQueue.offer(m);
            }
        }
    }

    @Override
    public List<String> groups() {
        return new ArrayList<String>(cache.keySet());
    }

    @Override
    public List<String> dialogIds(String group) {
        Map<String,Map> dialogMap = cache.get(group);
        if (dialogMap!=null){
            return new ArrayList<String>(dialogMap.keySet());
        }
        return null;
    }

    @Override
    public void remove(String group) {
        cache.remove(group);
    }

    @Override
    public void remove(String group, String dialogId) {
        Map dialog = cache.get(group);
        if (dialog!=null){
            dialog.remove(dialogId);
        }
    }
}
