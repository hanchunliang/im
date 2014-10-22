package org.onelab.im.core.domain.manager;

import org.onelab.im.core.DialogPanel;

import java.util.List;
import java.util.Map;

/**
 * 对话板管理器:创建对话板，获取对话板，关闭对话板
 * Created by chunliangh on 14-10-21.
 */
public class DialogPanelManager implements DialogManager {
    /**
     * 获取对话扳
     * @param dID
     * @return
     */
    DialogPanel dialogPanel(String dID){return null;};

    /**
     * 获取给定成员的对话id
     * @param attributes
     * @param participant
     * @return
     */
    List<String> dialogIds(Map<String,String> attributes,String participant){return null;};

    /**
     * 获取给定成员集的对话id
     * @param attributes
     * @param participants
     * @return
     */
    Map<String,List<String>> dialogIdsMap(Map<String,String> attributes,List<String> participants){return null;};
}
