package org.onelab.im.core.domain;

import org.onelab.im.core.domain.model.Dialog;
import org.onelab.im.core.domain.model.Message;

import java.util.List;

/**
 * 对话版。读写对话，一个对话有且仅有一个对话板
 * Created by chunliangh on 14-10-20.
 */
public class DialogPanel {

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
    int addMsg(Message message){return 0;};

    /**
     * 获取所有消息
     * @return
     */
    List<Message> messages(){return null;};

    /**
     * 从指定条目开始获取消息
     * @param from 从第几条获取,不包含该条
     * @return
     */
    List<Message> messages(int from){return null;};

    /**
     * 关闭对话
     */
    void close(){};
}
