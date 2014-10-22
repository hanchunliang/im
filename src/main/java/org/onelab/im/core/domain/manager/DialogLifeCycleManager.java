package org.onelab.im.core.domain.manager;

import java.util.List;
import java.util.Map;

/**
 * 对话生命周期管理器：创建对话，销毁对话，持久化对话
 * Created by chunliangh on 14-10-21.
 */
public class DialogLifeCycleManager implements DialogManager{
    /**
     * 创建对话
     * @param groupId 对话组ID
     * @param businessId 业务ID
     * @param attributes 对话属性
     * @param participants 对话参与者
     * @return  对话ID
     */
    String createDialog(String groupId,String businessId,Map<String,String> attributes,List<String> participants){return null;};

    /**
     * 创建对话
     * @param groupId 对话组ID
     * @return  对话ID
     */
    String createDialog(String groupId,String business){return null;};
}
