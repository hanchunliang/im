package org.onelab.im.core;

import java.util.List;
import java.util.Map;

/**
 * 对话版。读写对话，一个对话有且仅有一个对话板
 * Created by chunliangh on 14-10-20.
 */
public class DialogPanel {
    private String group;
    private String dialogId;
    public DialogPanel(String group,String dialogId){
        this.group = group;
        this.dialogId = dialogId;
    }
    /**
     * 获取对话信息
     * @return null 对话已关闭
     */
    public Map<String,String> getDialogInfo(){
        return DependenceRoot.dialogCache.dialogInfo(group, dialogId);
    }
    /**
     * 添加消息
     * @param message
     * @return 消息序号 -1消息增加失败，序号从0开始
     */
    public int write(Message message){
        return DependenceRoot.dialogCache.write(group,dialogId,message);
    }
    /**
     * 获取所有消息
     * @return null 对话已关闭
     */
    public List<Message> read(){
        List<Message> messages = DependenceRoot.dialogCache.read(group,dialogId);
        return messages;
    }
    /**
     * 从指定条目开始获取消息
     * @param startIndex 从第几条获取 条目编号从0开始
     * @return null 对话已关闭
     */
    public List<Message> read(int startIndex){
        List<Message> messages = DependenceRoot.dialogCache.read(group,dialogId);
        if (startIndex<0) startIndex = 0;
        return messages.subList(startIndex,messages.size());
    }
    /**
     * 从指定条目开始顺序获取指定条目数的消息
     * @param startIndex 从第几条获取 条目编号从0开始
     * @param len 指定条目数
     * @return null 对话已关闭
     */
    public List<Message> read(int startIndex,int len){
        List<Message> messages = DependenceRoot.dialogCache.read(group,dialogId);
        int endIndex = startIndex+len;
        if (endIndex>messages.size()) endIndex = messages.size();
        return messages.subList(startIndex,endIndex);
    }
}
