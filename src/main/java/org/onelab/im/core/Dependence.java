package org.onelab.im.core;

import org.onelab.im.core.dependence.CacheInterface;
import org.onelab.im.core.dependence.LogInterface;
import org.onelab.im.core.dependence.PersistenceInterface;

/**
 * Created by chunliangh on 14-10-21.
 */
public class Dependence {

    private CacheInterface cacheInterface;
    private PersistenceInterface persistenceInterface;
    private LogInterface logInterface;

    public Dependence(){}

    public Dependence(CacheInterface cacheInterface,PersistenceInterface persistenceInterface,LogInterface logInterface){
        this.cacheInterface = cacheInterface;
        this.persistenceInterface = persistenceInterface;
        this.logInterface = logInterface;
    }

    public CacheInterface getCacheInterface() {
        return cacheInterface;
    }

    public void setCacheInterface(CacheInterface cacheInterface) {
        this.cacheInterface = cacheInterface;
    }

    public PersistenceInterface getPersistenceInterface() {
        return persistenceInterface;
    }

    public void setPersistenceInterface(PersistenceInterface persistenceInterface) {
        this.persistenceInterface = persistenceInterface;
    }

    public LogInterface getLogInterface() {
        return logInterface;
    }

    public void setLogInterface(LogInterface logInterface) {
        this.logInterface = logInterface;
    }
}
