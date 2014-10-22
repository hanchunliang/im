package org.onelab.im.core.domain.repository;

import org.onelab.im.core.domain.model.Dialog;

import java.util.List;
import java.util.Map;

/**
 * 对话的持久化和历史查询
 * Created by chunliangh on 14-10-20.
 */
public class DialogRepository {

    /**
     * 持久化对话
     * @param dialogId 对话ID
     */
    void persistDialog(String dialogId){};
    void persistDialogs(List<String> dialogIDs){};
    /**
     * 历史对话信息
     * @param dialogId
     * @return
     */
    Dialog findDialogById(String groupId,String dialogId){return null;};
    List<Dialog> findDialogsByBusinessId(String groupId,String businessId){return null;};
    List<Dialog> findDialogsByBusinessIds(String groupId,List<String> businessIds){return null;};
    /**
     * 历史对话信息
     * @param attributes
     * @return
     */
    List<Dialog> findDialogsByAttributes(String groupId,Map<String,String> attributes){return null;};
    /**
     * 历史对话信息
     * @param participant
     * @return
     */
    List<Dialog> findDialogsByParticipant(String groupId,String participant){return null;};
    /**
     * 历史对话信息
     * @param attributes
     * @param participants
     * @return
     */
    Map<String,List<Dialog>> hisDialogsMap(String groupId,Map<String,String> attributes,List<String> participants){return null;};
}
