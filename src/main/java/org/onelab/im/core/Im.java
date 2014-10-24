package org.onelab.im.core;

import org.onelab.im.core.domain.DependenceRoot;
import org.onelab.im.core.domain.DialogManager;

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
     * @param dialogId not null 对话ID
     */
    public static void createDialog(String group,String dialogId,Map<String,String> dialogInfo){
        assert group!=null;
        assert dialogId!=null;
        dialogManager.createDialog(group,dialogId,dialogInfo);
        DependenceRoot.dialogLog.info("createDialog: {group="+group+",id="+dialogId+",dialogInfo="+dialogInfo+"}");
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
        DependenceRoot.dialogLog.info("destroyDialog: {group="+group+"}");
    }
    /**
     * 关闭给定对话
     * @param group 对话组 not null
     * @param dialogId 对话ID not null
     */
    public static void destroyDialog(String group,String dialogId){
        assert group!=null;
        assert dialogId!=null;
        dialogManager.destroyDialog(group,dialogId);
        DependenceRoot.dialogLog.info("destroyDialog: {group="+group+",dialogId="+dialogId+"}");
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
        return dialogManager.getDialogPanel(group);
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
        return dialogManager.getDialogPanel(group,dialogIds);
    }

    /**
     * 获取对话板
     * @param group not null
     * @param dialogInfo not null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Map<String,String> dialogInfo){
        assert group!=null;
        assert dialogInfo != null;
        return dialogManager.getDialogPanel(group,dialogInfo);
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
        return dialogManager.getDialogPanel(group, condition);
    }
}
