package org.onelab.im.core;

import org.onelab.im.basic.Cache;
import org.onelab.im.basic.DatabaseAccess;
import org.onelab.im.basic.Log;
import org.onelab.im.core.dependence.CacheInterface;
import org.onelab.im.core.dependence.LogInterface;
import org.onelab.im.core.dependence.PersistenceInterface;
import org.onelab.im.core.domain.manager.DialogGlobalManager;
import org.onelab.im.core.domain.manager.DialogLifeCycleManager;
import org.onelab.im.core.domain.manager.DialogMonitorManager;
import org.onelab.im.core.domain.manager.DialogPanelManager;

/**
 * Created by chunliangh on 14-10-22.
 */
public class Root {
    public static DialogGlobalManager global = new DialogGlobalManager();
    public static DialogLifeCycleManager lifeCycle = new DialogLifeCycleManager();
    public static DialogMonitorManager monitor = new DialogMonitorManager();
    public static DialogPanelManager panel = new DialogPanelManager();

    public static CacheInterface cache;
    public static PersistenceInterface persistence;
    public static LogInterface log;

    public static void init(Dependence dependence){
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
