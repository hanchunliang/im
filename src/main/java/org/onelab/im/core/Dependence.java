package org.onelab.im.core;

import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.dependence.DialogLogInterface;
import org.onelab.im.dependence.DialogPersistenceInterface;

/**
 * Created by chunliangh on 14-10-21.
 */
public class Dependence {

    private DialogCacheInterface dialogCacheInterface;
    private DialogPersistenceInterface persistenceInterface;
    private DialogLogInterface logInterface;

    public Dependence(){}

    public Dependence(DialogCacheInterface dialogCacheInterface,DialogPersistenceInterface persistenceInterface,DialogLogInterface logInterface){
        this.dialogCacheInterface = dialogCacheInterface;
        this.persistenceInterface = persistenceInterface;
        this.logInterface = logInterface;
    }

    public DialogCacheInterface getDialogCacheInterface() {
        return dialogCacheInterface;
    }

    public void setDialogCacheInterface(DialogCacheInterface dialogCacheInterface) {
        this.dialogCacheInterface = dialogCacheInterface;
    }

    public DialogPersistenceInterface getPersistenceInterface() {
        return persistenceInterface;
    }

    public void setPersistenceInterface(DialogPersistenceInterface persistenceInterface) {
        this.persistenceInterface = persistenceInterface;
    }

    public DialogLogInterface getLogInterface() {
        return logInterface;
    }

    public void setLogInterface(DialogLogInterface logInterface) {
        this.logInterface = logInterface;
    }
}
