package org.onelab.im.dependence;

import org.onelab.im.core.domain.Dialog;

import java.util.List;

/**
 * 持久化接口，需外部注入。
 * Created by chunliangh on 14-10-20.
 */
public interface DialogPersistenceInterface {
    int persist(Dialog dialog);
    int persist(List<Dialog> dialogs);
}
