package org.onelab.im.core.domain;

import org.onelab.im.core.Condition;
import org.onelab.im.core.DialogPanel;

import java.text.NumberFormat;
import java.util.*;

/**
 * 对话管理器，创建对话，销毁对话，获取对话板
 * Created by chunliangh on 14-10-21.
 */
public class DialogManager {
    private static DialogManager instance = new DialogManager();
    private DialogManager(){}
    public static DialogManager getInstance(){
        return instance;
    }
    /**
     * 创建对话
     * @param groupId 对话组ID
     * @param dialogId 对话ID
     * @param dialogInfo 对话信息
     */
    public void createDialog(String groupId, String dialogId, Map<String, String> dialogInfo){
        if(dialogInfo == null){
            dialogInfo = new HashMap<String, String>();
        }
        DependenceRoot.dialogCache.cache(groupId,dialogId,dialogInfo);
    };

    /**
     * 判断对话是否存在
     * @param group
     * @param dialogId
     * @return
     */
    public boolean hasDialog(String group,String dialogId){
        return DependenceRoot.dialogCache.exist(group,dialogId);
    }
    /**
     * 关闭给定对话组的对话
     * @param group
     */
    public void destroyDialog(String group) {
        List<Dialog> dialogs = new ArrayList<Dialog>();
        List<String> dialogIds = DependenceRoot.dialogCache.dialogIds(group);
        if (dialogIds!=null){
            for (String dialogId:dialogIds){
                Map<String,String> dialogInfo = DependenceRoot.dialogCache.dialogInfo(group,dialogId);
                List<Message> messages = DependenceRoot.dialogCache.read(group,dialogId);
                Dialog dialog = new Dialog(group,dialogId,dialogInfo,messages);
                dialogs.add(dialog);
            }
        }
        if (dialogs.size()>0){
            //删除缓存中记录
            DependenceRoot.dialogCache.remove(group);
            //持久化dialog
            DependenceRoot.dialogPersistence.persist(dialogs);
        }
    }

    /**
     * 销毁对话
     * @param group
     * @param dialogId
     */
    public void destroyDialog(String group, String dialogId) {
        Map<String,String> dialogInfo = DependenceRoot.dialogCache.dialogInfo(group,dialogId);
        List<Message> messages = DependenceRoot.dialogCache.read(group,dialogId);
        Dialog dialog = new Dialog(group,dialogId,dialogInfo,messages);
        //删除缓存中记录
        DependenceRoot.dialogCache.remove(group,dialogId);
        //持久化dialog
        DependenceRoot.dialogPersistence.persist(dialog);
    }

    /**
     * 获取对话板
     * @param group
     * @param dialogId
     * @return
     */
    public DialogPanel getDialogPanel(String group, String dialogId) {
        return new DialogPanel(group,dialogId);
    }

    /**
     * 获取对话板
     * @param group
     * @return
     */
    public List<DialogPanel> getDialogPanels(String group) {
        List<DialogPanel> dialogPanels = new ArrayList<DialogPanel>();
        List<String> dialogIds = DependenceRoot.dialogCache.dialogIds(group);
        if (dialogIds!=null){
            for (String dialogId:dialogIds){
                dialogPanels.add(new DialogPanel(group,dialogId));
            }
        }
        return dialogPanels;
    }

    /**
     * 获取对话板
     * @param group
     * @param dialogIds
     * @return
     */
    public List<DialogPanel> getDialogPanels(String group, Collection<String> dialogIds) {
        List<DialogPanel> dialogPanels = new ArrayList<DialogPanel>();
        List<String> dialogIdList = DependenceRoot.dialogCache.dialogIds(group);
        if (dialogIds!=null){
            for (String dialogId:dialogIdList){
                if (dialogIds.contains(dialogId)){
                    dialogPanels.add(new DialogPanel(group,dialogId));
                }
            }
        }
        return dialogPanels;
    }

    public List<DialogPanel> getDialogPanels(String group, Condition condition) {
        Map<String,Map<String,String>> dialogInfoMap = DependenceRoot.dialogCache.dialogInfoMap(group);
        List<String> dialogIds = getDialogIds(condition,dialogInfoMap);
        return getDialogPanels(group, dialogIds);
    }

    public List<String> getGroups() {
        return DependenceRoot.dialogCache.groups();
    }

    private List<String> getDialogIds(Condition condition,Map<String,Map<String,String>> dialogInfoMap) {
        List<String> dialogIds = new ArrayList<String>();
        if (dialogInfoMap != null){
            for (Map.Entry<String,Map<String,String>> entry:dialogInfoMap.entrySet()){
                Map<String,String> value = entry.getValue();
                if (checkCondition(condition, value)){
                    dialogIds.add(entry.getKey());
                }
            }
        }
        return dialogIds;
    }

    private boolean checkCondition(Condition condition, Map<String, String> dialogInfo) {
        Map<String,String> eq = condition.getEq();
        Map<String,String> nq = condition.getNq();
        Map<String,String> gt = condition.getGt();
        Map<String,String> lt = condition.getLt();
        Map<String,String> gte = condition.getGte();
        Map<String,String> lte = condition.getLte();

        boolean res = true;
        if (eq!=null && !eq.isEmpty()){
            res = eq(dialogInfo, eq);
        }
        if (res && nq!=null && !nq.isEmpty()){
            res = nq(dialogInfo, nq);
        }
        if (res && gt!=null && !gt.isEmpty()){
            res = gt(dialogInfo, gt);
        }
        if (res && lt!=null && !lt.isEmpty()){
            res = lt(dialogInfo, lt);
        }
        if (res && lte!=null && !lte.isEmpty()){
            res = lte(dialogInfo, lte);
        }
        if (res && gte!=null && !gte.isEmpty()){
            res = gte(dialogInfo, gte);
        }
        Condition or = condition.getOr();
        if (!res && or!=null && !or.isEmpty()){//如果条件校验不满足，且or非空，则继续校验or
            return checkCondition(or,dialogInfo);
        }
        return res;
    }

    private boolean eq(Map<String, String> map_1, Map<String, String> map_2) {
        Set<String> keySet_2 = map_2.keySet();
        for (String key:keySet_2){
            if (!map_2.get(key).equals(map_1.get(key))){
                return false;
            }
        }
        return true;
    }

    private boolean nq(Map<String, String> map_1, Map<String, String> map_2) {
        Set<String> keySet_2 = map_2.keySet();
        for (String key:keySet_2){
            if (map_2.get(key).equals(map_1.get(key))){
                return false;
            }
        }
        return true;
    }

    private boolean gt(Map<String, String> map_1, Map<String, String> map_2) {
        Set<String> keySet_2 = map_2.keySet();
        for (String key:keySet_2){
            String val_1 = map_1.get(key);
            String val_2 = map_2.get(key);
            if (val_1!=null){
                try {
                    float v1 = Float.parseFloat(val_1);
                    float v2 = Float.parseFloat(val_2);
                    if (v2<=v1) return false;
                } catch (NumberFormatException e){
                    if (val_2.compareTo(val_1)<=0) return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean lt(Map<String, String> map_1, Map<String, String> map_2) {
        Set<String> keySet_2 = map_2.keySet();
        for (String key:keySet_2){
            String val_1 = map_1.get(key);
            String val_2 = map_2.get(key);
            if (val_1!=null){
                try {
                    float v1 = Float.parseFloat(val_1);
                    float v2 = Float.parseFloat(val_2);
                    if (v2>=v1) return false;
                } catch (NumberFormatException e){
                    if (val_2.compareTo(val_1)>=0) return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean gte(Map<String, String> map_1, Map<String, String> map_2) {
        Set<String> keySet_2 = map_2.keySet();
        for (String key:keySet_2){
            String val_1 = map_1.get(key);
            String val_2 = map_2.get(key);
            if (val_1!=null){
                try {
                    float v1 = Float.parseFloat(val_1);
                    float v2 = Float.parseFloat(val_2);
                    if (v2<v1) return false;
                } catch (NumberFormatException e){
                    if (val_2.compareTo(val_1)<0) return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean lte(Map<String, String> map_1, Map<String, String> map_2) {
        Set<String> keySet_2 = map_2.keySet();
        for (String key:keySet_2){
            String val_1 = map_1.get(key);
            String val_2 = map_2.get(key);
            if (val_1!=null){
                try {
                    float v1 = Float.parseFloat(val_1);
                    float v2 = Float.parseFloat(val_2);
                    if (v2>v1) return false;
                } catch (NumberFormatException e){
                    if (val_2.compareTo(val_1)>0) return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
