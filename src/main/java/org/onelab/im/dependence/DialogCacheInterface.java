package org.onelab.im.dependence;

import org.onelab.im.core.Message;

import java.util.List;
import java.util.Map;

/**
 * 对话信息缓存接口，需外部实现。
 * 需要提供默认无参构造子
 * Created by chunliangh on 14-10-20.
 */
public interface DialogCacheInterface {
    /**
     * 创建对话时默认在对话信息中保存对话开始时间，起Key为INFO_CREATETIME_KEY
     */
    public static final String INFO_CREATETIME_KEY = "info_createtime";

    void cache(String group,String dialogId,Map<String,String> dialogInfo);

    Map<String,String> dialogInfo(String group, String dialogId);

    List<Message> read(String group,String dialogId);
    int write(String group,String dialogId,Message message);

    List<String> getGroups();
    List<String> getDialogIds(String group);
    List<String> getDialogIds(String group,Map<String,String> dialogInfo);

    void remove(String group,String dialogId);
    void remove(String group);
}
