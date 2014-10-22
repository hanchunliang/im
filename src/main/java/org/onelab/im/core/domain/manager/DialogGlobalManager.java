package org.onelab.im.core.domain.manager;

import java.util.List;

/**
 * 对话全局管理：对话成员管理，对话属性管理
 * Created by chunliangh on 14-10-21.
 */
public class DialogGlobalManager implements DialogManager {
    /**
     * 增加对话参与者
     * @param dID
     * @param participant
     */
    void addParticipant(String dID,String participant){};

    /**
     * 增加对话参与者
     * @param dIDs
     * @param participant
     */
    void addParticipant(List<String> dIDs,String participant){};

    /**
     * 删除对话参与者，对话参与者一旦被删除将被提出对话板，但dialog中还会保存改参与者信息
     * @param dID
     * @param participant
     */
    void removeParticipant(String dID,String participant){};

    /**
     * 删除对话参与者，对话参与者一旦被删除将被提出对话板，但dialog中还会保存改参与者信息
     * @param dIDs
     * @param participant
     */
    void removeParticipant(List<String> dIDs,String participant){};

    /**
     * 设置对话属性
     * @param name
     * @param value
     */
    void putAttribute(String name,String value){};
}
