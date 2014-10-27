package org.onelab.im.core;

import org.onelab.im.core.domain.DependenceRoot;
import org.onelab.im.core.domain.Message;

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
     * @return 对话信息 [如果不存在给定对话对话,返回null]
     */
    public Map<String,String> getDialogInfo(){
        Map<String,String> dialogInfo = DependenceRoot.dialogCache.dialogInfo(group, dialogId);
        return dialogInfo;
    }
    /**
     * 添加消息
     * @param message
     * @return 消息数 从1开始，[如果不存在给定对话,返回0]
     */
    public int write(Message message){
        int size = DependenceRoot.dialogCache.write(group,dialogId,message);
        return size;
    }
    /**
     * 获取所有消息
     * @return 当前对话的所有消息 [如果不存在给定对话对话,返回null]
     */
    public List<Message> read(){
        List<Message> messages = DependenceRoot.dialogCache.read(group,dialogId);
        return messages;
    }
    /**
     * 从指定条目开始获取消息
     * @param startIndex 从第几条获取 条目编号从0开始
     * @return [如果不存在给定对话对话,返回null]
     */
    public List<Message> read(int startIndex){
        List<Message> messages = read();
        if (startIndex<0) startIndex = 0;
        return messages.subList(startIndex,messages.size());
    }
    /**
     * 从指定条目开始顺序获取指定条目数的消息
     * @param startIndex 从第几条获取 条目编号从0开始
     * @param len 指定条目数
     * @return [如果不存在给定对话对话,返回null]
     */
    public List<Message> read(int startIndex,int len){
        List<Message> messages = read();
        int endIndex = startIndex+len;
        if (endIndex>messages.size()) endIndex = messages.size();
        return messages.subList(startIndex,endIndex);
    }
}
