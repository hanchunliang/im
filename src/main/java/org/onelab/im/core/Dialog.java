package org.onelab.im.core;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chunliangh on 14-10-23.
 */
public class Dialog {
    public Dialog(String group,String id,Map<String,String> info){
        this.group = group;
        this.id = id;
        this.info = info;
    }
    /**
     * 对话所属范围
     */
    private String group;
    /**
     * 唯一标识
     */
    private String id;
    /**
     * 对话信息，记录对话的一些特征数据。 非法字符：空格和分号
     */
    private Map<String,String> info;
    /**
     * 对话创建时间
     */
    private Date ts;
    /**
     * 对话销毁时间
     */
    private Date te;
    /**
     * 对话内容
     */
    private List<Message> messages;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Date getTe() {
        return te;
    }

    public void setTe(Date te) {
        this.te = te;
    }
}
