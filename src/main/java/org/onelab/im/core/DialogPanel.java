package org.onelab.im.core;

import org.onelab.im.core.domain.model.Dialog;
import org.onelab.im.core.domain.model.Message;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 对话版。读写对话，一个对话有且仅有一个对话板
 * Created by chunliangh on 14-10-20.
 */
public class DialogPanel {
    private String group;
    private String dialogId;
    public DialogPanel(String group,String dialogId){}
    /**
     * 增加对话成员
     * @param participant
     */
    public void addParticipant(String participant){

    }
    /**
     * 增加对话成员
     * @param participants
     */
    public void addParticipants(Collection<String> participants){}
    /**
     * 删除对话成员
     * @param participant
     */
    public void removeParticipant(String participant){

    }
    /**
     * 删除对话成员
     * @param participants
     */
    public void removeParticipant(Collection<String> participants){

    }
    /**
     * 为成员变量负值，如果没有所需成员变量则创建并负值
     * @param name
     * @param value
     */
    public void setAttribute(String name,String value){}
    /**
     * 为成员变量负值，如果没有所需成员变量则创建并负值
     * @param attributes
     */
    public void setAttributes(Map<String,String> attributes){}
    /**
     * 删除成员变量
     * @param name
     */
    public void removeAttribute(String name){}
    /**
     * 删除成员变量
     * @param names
     */
    public void removeAttributes(Collection<String> names){}
    /**
     * 获取对话
     * @return
     */
    Dialog getDialog(){return null;};
    /**
     * 添加消息
     * @param message
     * @return 消息序号 0消息增加失败，序号从1开始
     */
    int write(Message message){
        return 0;
    };
    /**
     * 获取所有消息
     * @return
     */
    List<Message> read(){return null;};
    /**
     * 从指定条目开始获取消息
     * @param startIndex 从第几条获取 条目编号从1开始
     * @return
     */
    List<Message> read(int startIndex){return null;};
    /**
     * 从指定条目开始顺序获取指定条目数的消息
     * @param startIndex 从第几条获取 条目编号从1开始
     * @param len 指定条目数
     * @return
     */
    List<Message> read(int startIndex,int len){
        return null;
    }
}
