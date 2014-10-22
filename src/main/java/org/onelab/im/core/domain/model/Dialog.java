package org.onelab.im.core.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 对话基本信息
 * Created by chunliangh on 14-10-20.
 */
public class Dialog {
    /**
     * 唯一标识
     */
    private String id;
    /**
     * 对话所属范围
     */
    private String group;
    /**
     * 对话对外关联标记
     */
    private String businessId;
    /**
     * 对话参与者，有权发送和接收消息的人
     */
    private List<String> participants;
    /**
     * 对话属性，记录对话的一些特征数据。 非法字符：空格和分号
     */
    private Map<String,String> attributes;
    /**
     * 对话创建时间
     */
    private Date ts;
    /**
     * 对话结束时间
     */
    private Date te;
    /**
     * 对话内容
     */
    private List<Message> messages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
