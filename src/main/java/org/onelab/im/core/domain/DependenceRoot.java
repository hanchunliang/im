package org.onelab.im.core.domain;

import org.onelab.im.basic.DialogCache;
import org.onelab.im.basic.DialogPersistence;
import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.dependence.DialogPersistenceInterface;

/**
 * 外部依赖注册表
 * Created by chunliangh on 14-10-22.
 */
public class DependenceRoot {
    public static DialogCacheInterface dialogCache;
    public static DialogPersistenceInterface dialogPersistence;

    public static void init(DialogCacheInterface dialogCache, DialogPersistenceInterface dialogPersistence) {
        if (dialogCache!=null){
            DependenceRoot.dialogCache = dialogCache;
        } else {
            DependenceRoot.dialogCache = new DialogCache();
        }
        if (dialogPersistence!=null){
            DependenceRoot.dialogPersistence = dialogPersistence;
        } else {
            DependenceRoot.dialogPersistence = new DialogPersistence();
        }
    }
}
