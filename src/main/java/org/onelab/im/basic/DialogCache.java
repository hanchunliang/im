package org.onelab.im.basic;

import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.core.domain.Message;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        if (dialogInfo!=null){
            dialogMap.put(key_info,dialogInfo);
        }
        dialogMap.put(key_msg,new LinkedList<Message>());
        groupMap.put(dialogId,dialogMap);
    }

    @Override
    public void remove(String group, String dialogId) {
        Map dialog = cache.get(group);
        if (dialog!=null){
            dialog.remove(dialogId);
        }
    }

    @Override
    public void remove(String group) {
        cache.remove(group);
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
    public Map<String, String> dialogInfo(String group, String dialogId) {
        Map<String,Map> groupMap = cache.get(group);
        if (groupMap!=null){
            Map<String,Map> dialogMap = groupMap.get(dialogId);
            if (dialogMap!=null){
                return dialogMap.get(key_info);
            }
        }
        return null;
    }

    @Override
    public Map<String, Map<String, String>> dialogInfoMap(String group) {
        Map<String,Map> groupMap = cache.get(group);
        Map<String,Map<String,String>> res = null;
        if (groupMap!=null){
            res = new HashMap<String, Map<String, String>>();
            for (Map.Entry<String,Map> dialogEntry:groupMap.entrySet()){
                Map<String, String> dialogInfo = (Map<String, String>) dialogEntry.getValue().get(key_info);
                if (dialogInfo!=null){
                    res.put(dialogEntry.getKey(), dialogInfo);
                }
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
                return (List<Message>) dialogMap.get(key_msg);
            }
        }
        return null;
    }

    @Override
    public void write(String group, String dialogId, Message message) {
        Map<String,Map> groupMap = cache.get(group);
        if (groupMap!=null) {
            Map dialogMap = groupMap.get(dialogId);
            if (dialogMap!=null){
                List<Message> messageQueue = (List<Message>) dialogMap.get(key_msg);
                synchronized (messageQueue){
                    int size = messageQueue.size();
                    message.setIndex(size);
                    messageQueue.add(message);
                }
            }
        }
    }
}
