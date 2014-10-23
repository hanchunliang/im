package org.onelab.im.basic;

import org.onelab.im.dependence.DialogPersistenceInterface;
import org.onelab.im.core.Dialog;

import java.util.List;

/**
 * Created by chunliangh on 14-10-21.
 */
public class DialogPersistence implements DialogPersistenceInterface {
    @Override
    public int persist(Dialog dialog) {
        return 0;
    }

    @Override
    public int persist(List<Dialog> dialogs) {
        return 0;
    }
}
