package org.onelab.im.core.dependence;

/**
 * 日志接口，需外部提供实现。
 * 需要提供默认无参构造子
 * Created by chunliangh on 14-10-21.
 */
public interface LogInterface {
    void debug(String msg, Throwable t);
    void info(String msg, Throwable t);
    void warn(String msg, Throwable t);
    void error(String msg, Throwable t);
}
