package org.onelab.im.core;

import org.onelab.im.core.domain.DependenceRoot;
import org.onelab.im.core.domain.DialogManager;
import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.dependence.DialogPersistenceInterface;

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
     * 开启IM引擎
     * @param dialogCache 外部提供。null表示使用IM引擎提供的默认值
     * @param dialogPersistence 外部提供。null表示使用IM引擎提供的默认值
     * @throws Exception
     */
    public static void start(DialogCacheInterface dialogCache,DialogPersistenceInterface dialogPersistence){
        DependenceRoot.init(dialogCache, dialogPersistence);
    }
    /**
     * 创建对话
     * @param group mustNot null 对话组
     * @param dialogId mustNot null 对话ID
     */
    public static void createDialog(String group,String dialogId,Map<String,String> dialogInfo){
        assert group!=null;
        assert dialogId!=null;
        dialogManager.createDialog(group, dialogId, dialogInfo);
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
     * @param group 对话组 mustNot null
     */
    public static void destroyDialog(String group){
        assert group!=null;
        dialogManager.destroyDialog(group);
    }
    /**
     * 关闭给定对话
     * @param group 对话组 mustNot null
     * @param dialogId 对话ID mustNot null
     */
    public static void destroyDialog(String group,String dialogId){
        assert group!=null;
        assert dialogId!=null;
        dialogManager.destroyDialog(group, dialogId);
    }
    /**
     * 获取对话板
     * @param group 对话组 mustNot null
     * @param dialogId 对话ID mustNot null
     * @return
     */
    public static DialogPanel getDialogPanel(String group,String dialogId){
        assert group!=null;
        assert dialogId!=null;
        return dialogManager.getDialogPanel(group,dialogId);
    }
    /**
     * 获取对话板
     * @param group mustNot null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group){
        assert group!=null;
        return dialogManager.getDialogPanel(group);
    }

    /**
     * 获取对话板
     * @param group mustNot null
     * @param dialogIds mustNot null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Collection<String> dialogIds){
        assert group!=null;
        assert dialogIds!=null;
        return dialogManager.getDialogPanel(group,dialogIds);
    }

    /**
     * 获取对话板
     * @param group mustNot null
     * @param condition mustNot null
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Condition condition){
        assert group!=null;
        assert condition != null;
        return dialogManager.getDialogPanel(group, condition);
    }
    /**
     * 停止IM引擎
     */
    public static void stop() throws Exception{
        ImEngine.destroyDialog();
    }
}
