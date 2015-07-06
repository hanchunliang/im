package org.onelab.im.dependence;

import java.util.List;
import java.util.Map;

/**
 * 对话缓存接口，需外部注入。
 * Created by chunliangh on 14-10-20.
 */
public interface DialogCacheInterface extends MessageTransferInterface{

    /**
     * 缓存给定对话的信息
     * @param group 对话组
     * @param dialogId 对话ID
     * @param dialogInfo 对话信息
     */
    void cache(String group,String dialogId,Map<String,String> dialogInfo);

    /**
     * 判断对话是否存在
     * @param group
     * @param dialogId
     * @return
     */
    boolean exist(String group, String dialogId);

    /**
     * 更新对话信息
     * @param group
     * @param dialogId
     * @param dialogInfo 对话信息
     */
    void updateDialogInfo(String group, String dialogId, Map<String, String> dialogInfo);

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

    /**
     * 删除给定对话组的对话
     * @param group 对话组
     */
    void remove(String group);

    /**
     * 删除缓存中的给定对话信息
     * @param group 对话组
     * @param dialogId 对话ID
     */
    void remove(String group,String dialogId);
}
