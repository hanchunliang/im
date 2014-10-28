package org.onelab.im.dependence;

import org.onelab.im.core.domain.Message;

import java.util.List;
import java.util.Map;

/**
 * 对话缓存接口，需外部注入。
 * Created by chunliangh on 14-10-20.
 */
public interface DialogCacheInterface {

    /**
     * 缓存给定对话的信息
     * @param group 对话组
     * @param dialogId 对话ID
     * @param dialogInfo 对话信息
     */
    void cache(String group,String dialogId,Map<String,String> dialogInfo);

    /**
     * 删除缓存中的给定对话信息
     * @param group 对话组
     * @param dialogId 对话ID
     */
    void remove(String group,String dialogId);

    /**
     * 删除给定对话组的对话
     * @param group 对话组
     */
    void remove(String group);

    /**
     * 设置对话信息
     * @param group
     * @param dialogId
     * @param dialogInfo
     */
    void setDialogInfo(String group, String dialogId,Map<String,String> dialogInfo);

    /**
     * 获取给定对话的信息
     * @param group 对话组
     * @param dialogId 对话ID
     * @return 对话信息 [如果不存在给定对话对话,返回null]
     */
    Map<String,String> dialogInfo(String group, String dialogId);

    /**
     * 获取给定对话组的对话信息
     * @param group 对话组
     * @return <dialogId,dialogInfo> [如果不存在给定对话组,返回null]
     */
    Map<String,Map<String,String>> dialogInfoMap(String group);

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

    /**
     * 获取所有对话组
     * @return 对话组
     */
    List<String> groups();

    /**
     * 获取给定对话组下的对话ID
     * @param group 对话组
     * @return 对话ID [如果不存在给定给定对话组,返回null]
     */
    List<String> dialogIds(String group);
}
