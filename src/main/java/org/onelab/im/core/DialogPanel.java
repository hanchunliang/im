package org.onelab.im.core;

import org.onelab.im.core.domain.DependenceRoot;
import org.onelab.im.core.domain.Message;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对话版。读写消息，查看或更新对话信息
 * Created by chunliangh on 14-10-20.
 */
public class DialogPanel {
    private String group;
    private String dialogId;
    public DialogPanel(String group,String dialogId){
        this.group = group;
        this.dialogId = dialogId;
    }
    public boolean active(){
        return DependenceRoot.dialogCache.exist(group,dialogId);
    }
    /**
     * 获取对话信息
     * @return 对话信息 [如果不存在给定对话对话,返回null]
     */
    public Map<String,String> getDialogInfo(){
        return DependenceRoot.dialogCache.dialogInfo(group, dialogId);
    }
    /**
     * 设置对话信息
     * @param name 属性
     * @param value 值
     */
    public void updateDialogInfo(String name,String value){
        Map<String,String> dialogInfo = new HashMap<String, String>();
        dialogInfo.put(name,value);
        DependenceRoot.dialogCache.updateDialogInfo(group, dialogId, dialogInfo);
    }
    /**
     * 设置对话信息
     * @param dialogInfo 对话信息
     */
    public void updateDialogInfo(Map<String,String> dialogInfo){
        DependenceRoot.dialogCache.updateDialogInfo(group, dialogId, dialogInfo);
    }
    /**
     * 添加消息
     * @param message
     */
    public void write(Message message){
        DependenceRoot.dialogCache.write(group,dialogId,message);
    }
    /**
     * 获取所有消息
     * @return 当前对话的所有消息 [如果不存在给定对话对话,返回null]
     */
    public List<Message> read(){
        return DependenceRoot.dialogCache.read(group,dialogId);
    }
    /**
     * 从指定条目开始获取消息
     * @param startIndex 从第几条获取 条目编号从0开始
     * @return [如果不存在给定对话对话,返回null]
     */
    public List<Message> read(int startIndex){
        List<Message> messages = read();
        if (messages!=null){
            int size = messages.size();
            if (startIndex>=size){
                messages = Collections.EMPTY_LIST;
            } else {
                if (startIndex<0) startIndex = 0;
                messages = messages.subList(startIndex,size);
            }
        }
        return messages;
    }
    /**
     * 从指定条目开始顺序获取指定条目数的消息
     * @param startIndex 从第几条获取 条目编号从0开始
     * @param len 指定条目数
     * @return [如果不存在给定对话对话,返回null]
     */
    public List<Message> read(int startIndex,int len){
        List<Message> messages = read();
        if (messages!=null){
            int size = messages.size();
            if (startIndex>=size){
                messages = Collections.EMPTY_LIST;
            } else {
                if (startIndex<0) startIndex = 0;
                int endIndex = startIndex+len;
                if (endIndex>size) endIndex = size;
                messages = messages.subList(startIndex,endIndex);
            }
        }
        return messages;
    }
}
