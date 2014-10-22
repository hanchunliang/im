package org.onelab.im.basic;

import org.onelab.im.core.dependence.PersistenceInterface;
import org.onelab.im.core.domain.model.Dialog;

import java.util.List;

/**
 * Created by chunliangh on 14-10-21.
 */
public class DatabaseAccess implements PersistenceInterface {
    @Override
    public int save(Dialog dialog) {
        return 0;
    }

    @Override
    public int save(List<Dialog> dialogs) {
        return 0;
    }
}
