package org.onelab.im.core;

import org.onelab.im.basic.Cache;
import org.onelab.im.basic.DatabaseAccess;
import org.onelab.im.basic.Log;
import org.onelab.im.core.dependence.CacheInterface;
import org.onelab.im.core.dependence.LogInterface;
import org.onelab.im.core.dependence.PersistenceInterface;

/**
 * 外部依赖注册表
 * Created by chunliangh on 14-10-22.
 */
public class DependenceRoot {
    public static CacheInterface cache;
    public static PersistenceInterface persistence;
    public static LogInterface log;

    static void init(Dependence dependence){
        cache = new Cache();
        persistence = new DatabaseAccess();
        log = new Log();
        if (dependence.getCacheInterface()!=null){
            cache = dependence.getCacheInterface();
        }
        if (dependence.getPersistenceInterface()!=null){
            persistence = dependence.getPersistenceInterface();
        }
        if (dependence.getLogInterface()!=null){
            log = dependence.getLogInterface();
        }
    }
}
