package org.onelab.im.dependence;

import org.onelab.im.core.domain.Message;

import java.util.List;

/**
 * Created by daojian on 15/7/6.
 */
public interface MessageTransferInterface {
  /**
   * 读取给定对话的消息
   * @param group 对话组
   * @param dialogId 对话ID
   * @return 给定对话的所有消息 [如果不存在给定对话对话,返回null]
   */
  List<Message> read(String group,String dialogId);

  /**
   * 向给定对话添加消息
   * @param group 对话组
   * @param dialogId 对话ID
   * @param message 消息
   */
  void write(String group,String dialogId,Message message);
}
