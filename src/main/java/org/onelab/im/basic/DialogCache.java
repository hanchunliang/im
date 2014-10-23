package org.onelab.im.basic;

import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.core.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by chunliangh on 14-10-21.
 */
public class DialogCache implements DialogCacheInterface {

    @Override
    public void cache(String group, String dialogId, Map<String, String> dialogInfo) {

    }

    @Override
    public void remove(String group, String dialogId) {

    }

    @Override
    public void remove(String group) {

    }

    @Override
    public Map<String, String> dialogInfo(String group, String id) {
        return null;
    }

    @Override
    public List<Message> read(String group, String dialogId) {
        return null;
    }

    @Override
    public int write(String group, String dialogId, Message message) {
        return 0;
    }

    @Override
    public List<String> getGroups() {
        return null;
    }

    @Override
    public List<String> getDialogIds(String group) {
        return null;
    }

    @Override
    public List<String> getDialogIds(String group, Map<String, String> dialogInfo) {
        return null;
    }
}
