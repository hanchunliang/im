package org.onelab.im.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * IM引擎外部使用接口
 * Created by chunliangh on 14-10-21.
 */
public class Im {
    private static DialogManager dialogManager = DialogManager.getInstance();
    /**
     * 创建对话
     * @param group not null 对话组
     * @param id not null 对话ID
     */
    public static void createDialog(String group,String id,Map<String,String> dialogInfo){
        dialogManager.createDialog(group,id,dialogInfo);
    }
    /**
     * 关闭所有对话
     */
    public static void destroyDialog(){
        List<String> groups = dialogManager.getGroups();
        for (String group:groups){
            dialogManager.destroyDialog(group);
        }
    }
    /**
     * 关闭给定对话组的对话
     * @param group 对话组
     */
    public static void destroyDialog(String group){
        dialogManager.destroyDialog(group);
    }
    /**
     * 关闭给定对话
     * @param group 对话组
     * @param dialogId 对话ID
     */
    public static void destroyDialog(String group,String dialogId){
        dialogManager.destroyDialog(group,dialogId);
    }
    /**
     * 获取对话板
     * @param group 对话组
     * @param dialogId 对话ID
     * @return
     */
    public static DialogPanel getDialogPanel(String group,String dialogId){
        return dialogManager.getDialogPanel(group,dialogId);
    }
    /**
     * 获取对话板
     * @param group
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group){
        return dialogManager.getDialogPanel(group);
    }

    /**
     * 获取对话板
     * @param group
     * @param dialogIds
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Collection<String> dialogIds){
        return dialogManager.getDialogPanel(group,dialogIds);
    }

    /**
     * 获取对话板
     * @param group
     * @param dialogInfo
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Map<String,String> dialogInfo){
        return dialogManager.getDialogPanel(group,dialogInfo);
    }
}
