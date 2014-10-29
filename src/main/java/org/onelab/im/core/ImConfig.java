package org.onelab.im.core;

import org.onelab.im.core.domain.DependenceRoot;
import org.onelab.im.dependence.DialogCacheInterface;
import org.onelab.im.dependence.DialogPersistenceInterface;

/**
 * Created by chunliangh on 14-10-29.
 */
public class ImConfig {
    /**
     * 初始化IM引擎
     * @param dialogCache 外部提供。null表示使用IM引擎提供的默认值
     * @param dialogPersistence 外部提供。null表示使用IM引擎提供的默认值
     * @throws Exception
     */
    public static void init(DialogCacheInterface dialogCache,DialogPersistenceInterface dialogPersistence){
        DependenceRoot.init(dialogCache, dialogPersistence);
    }
    /**
     * 停止IM引擎
     */
    public static void destroy() {
        ImEngine.destroyDialog();
    }
}
