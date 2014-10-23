package org.onelab.im.core.domain;

import org.onelab.im.core.DialogPanel;

import java.util.*;

/**
 * 对话生命周期管理器：创建对话，销毁对话，持久化对话
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
     * 关闭给定对话组的对话
     * @param group
     */
    public void destroyDialog(String group) {
        List<Dialog> dialogs = new ArrayList<Dialog>();
        List<String> dialogIds = DependenceRoot.dialogCache.getDialogIds(group);
        if (dialogIds!=null){
            for (String dialogId:dialogIds){
                Map<String,String> dialogInfo = DependenceRoot.dialogCache.dialogInfo(group,dialogId);
                Dialog dialog = new Dialog(group,dialogId,dialogInfo);
                dialogs.add(dialog);
            }
        }else{
            DependenceRoot.dialogLog.warn("DialogManager.destroyDialog: no group[" + group + "]");
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
        Dialog dialog = new Dialog(group,dialogId,dialogInfo);
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
    public List<DialogPanel> getDialogPanel(String group) {
        List<DialogPanel> dialogPanels = new ArrayList<DialogPanel>();
        List<String> dialogIds = DependenceRoot.dialogCache.getDialogIds(group);
        if (dialogIds!=null){
            for (String dialogId:dialogIds){
                dialogPanels.add(new DialogPanel(group,dialogId));
            }
        }else{
            DependenceRoot.dialogLog.warn("DialogManager.getDialogPanel: no group["+group+"]");
        }
        return dialogPanels;
    }

    /**
     * 获取对话板
     * @param group
     * @param dialogIds
     * @return
     */
    public List<DialogPanel> getDialogPanel(String group, Collection<String> dialogIds) {
        List<DialogPanel> dialogPanels = new ArrayList<DialogPanel>();
        List<String> dialogIdList = DependenceRoot.dialogCache.getDialogIds(group);
        if (dialogIds!=null){
            for (String dialogId:dialogIdList){
                if (dialogIds.contains(dialogId)){
                    dialogPanels.add(new DialogPanel(group,dialogId));
                }
            }
        }else{
            DependenceRoot.dialogLog.warn("DialogManager.getDialogPanel: no group["+group+"]");
        }
        return dialogPanels;
    }

    public List<DialogPanel> getDialogPanel(String group, Map<String, String> dialogInfo) {
        List<String> dialogIds = DependenceRoot.dialogCache.getDialogIds(group,dialogInfo);
        if (dialogIds == null){
            DependenceRoot.dialogLog.warn("DialogManager.getDialogPanel: no group["+group+"]");
        }
        return getDialogPanel(group,dialogIds);
    }

    public List<String> getGroups() {
        return DependenceRoot.dialogCache.getGroups();
    }
}
