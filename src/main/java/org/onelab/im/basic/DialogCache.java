package org.onelab.im.basic;

import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.core.domain.Message;

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
    public List<String> groups() {
        return null;
    }

    @Override
    public List<String> dialogIds(String group) {
        return null;
    }

    @Override
    public Map<String, String> dialogInfo(String group, String id) {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> dialogInfoMap(String group) {
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
}
