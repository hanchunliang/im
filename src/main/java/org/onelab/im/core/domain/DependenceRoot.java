package org.onelab.im.core.domain;

import org.onelab.im.basic.DialogCache;
import org.onelab.im.basic.DialogPersistence;
import org.onelab.im.basic.DialogLog;
import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.dependence.DialogLogInterface;
import org.onelab.im.dependence.DialogPersistenceInterface;

/**
 * 外部依赖注册表
 * Created by chunliangh on 14-10-22.
 */
public class DependenceRoot {
    public static DialogCacheInterface dialogCache;
    public static DialogPersistenceInterface dialogPersistence;
    public static DialogLogInterface dialogLog;

    public static void init(Dependence dependence){
        dialogCache = new DialogCache();
        dialogPersistence = new DialogPersistence();
        dialogLog = new DialogLog();
        if (dependence.getDialogCacheInterface()!=null){
            dialogCache = dependence.getDialogCacheInterface();
        }
        if (dependence.getPersistenceInterface()!=null){
            dialogPersistence = dependence.getPersistenceInterface();
        }
        if (dependence.getLogInterface()!=null){
            dialogLog = dependence.getLogInterface();
        }
    }
}
