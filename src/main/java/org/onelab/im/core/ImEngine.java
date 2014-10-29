package org.onelab.im.core;

import org.onelab.im.core.domain.DialogManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * IM引擎外部使用接口
 * Created by chunliangh on 14-10-21.
 */
public class ImEngine {
    private static DialogManager dialogManager = DialogManager.getInstance();
    /**
     * 创建对话
     * @param group not null 对话组
     * @param dialogId not null 对话ID
     */
    public static void createDialog(String group,String dialogId,Map<String,String> dialogInfo){
        assert group!=null;
        assert dialogId!=null;
        dialogManager.createDialog(group, dialogId, dialogInfo);
    }

    /**
     *
     * @param group not null 对话组
     * @param dialogId not null 对话ID
     * @return false 不存在，true 存在
     */
    public static boolean hasDialog(String group,String dialogId){
        assert group!=null;
        assert dialogId!=null;
        return dialogManager.hasDialog(group,dialogId);
    }
    /**
     * 关闭所有对话
     */
    public static void destroyDialog(){
        List<String> groups = dialogManager.getGroups();
        if (groups!=null){
            for (String group:groups){
                destroyDialog(group);
            }
        }
    }
    /**
     * 关闭给定对话组的对话
     * @param group 对话组 not null
     */
    public static void destroyDialog(String group){
        assert group!=null;
        dialogManager.destroyDialog(group);
    }
    /**
     * 关闭给定对话
     * @param group 对话组 not null
     * @param dialogId 对话ID not null
     */
    public static void destroyDialog(String group,String dialogId){
        assert group!=null;
        assert dialogId!=null;
        dialogManager.destroyDialog(group, dialogId);
    }
    /**
     * 获取对话板
     * @param group 对话组 not null
     * @param dialogId 对话ID not null
     * @return
     */
    public static DialogPanel getDialogPanel(String group,String dialogId){
        assert group!=null;
        assert dialogId!=null;
        return dialogManager.getDialogPanel(group,dialogId);
    }
    /**
     * 获取对话板
     * @param group not null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group){
        assert group!=null;
        return dialogManager.getDialogPanels(group);
    }

    /**
     * 获取对话板
     * @param group not null
     * @param dialogIds not null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Collection<String> dialogIds){
        assert group!=null;
        assert dialogIds!=null;
        return dialogManager.getDialogPanels(group, dialogIds);
    }

    /**
     * 获取对话板
     * @param group not null
     * @param condition not null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Condition condition){
        assert group!=null;
        assert condition != null;
        if (condition.isEmpty()){
            return dialogManager.getDialogPanels(group);
        }else{
            return dialogManager.getDialogPanels(group, condition);
        }
    }
}
