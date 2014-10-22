package org.onelab.im.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * IM引擎外部使用接口
 * Created by chunliangh on 14-10-21.
 */
public class Im {
    /**
     * 创建对话
     * @param group not null 对话组
     * @param id not null 业务ID
     */
    public static void createDialog(String group,String id){}
    /**
     * 创建对话
     * @param group not null 对话组
     * @param id not null 对话ID
     * @param participants 成员
     * @param attributes 变量
     */
    public static void createDialog(String group,String id,Collection<String> participants,Map<String,String> attributes){}
    /**
     * 关闭给定对话组的对话
     * @param group
     */
    public static void closeDialog(String group){

    }
    /**
     * 关闭给定对话
     * @param group 对话组
     * @param id 对话ID
     */
    public static void closeDialog(String group,String id){

    }
    /**
     * 获取对话板
     * @param group 对话组
     * @param id 对话ID
     * @return
     */
    public static DialogPanel getDialogPanel(String group,String id){
        return null;
    }
    /**
     * 获取对话板
     * @param group
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group){return null;}
    /**
     * 获取对话板
     * @param participant
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,String participant){
        return null;
    }
    /**
     * 获取对话板
     * @param participants
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Collection<String> participants){
        return null;
    }
    /**
     * 获取对话板
     * @param group
     * @param attributes
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Map<String,String> attributes){
        return null;
    }
    /**
     * 获取对话板
     * @param group
     * @param participant
     * @param attributes
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,String participant,Map<String,String> attributes){
        return null;
    }
    /**
     * 获取对话板
     * @param group
     * @param participants
     * @param attributes
     * @return
     */
    public static List<DialogPanel> getDialogPanels(String group,Collection<String> participants,Map<String,String> attributes){
        return null;
    }

}
