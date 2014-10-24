package org.onelab.im.dependence;

/**
 * 日志接口，需外部注入。
 * Created by chunliangh on 14-10-21.
 */
public interface DialogLogInterface {
    void info(String msg);
    void warn(String msg);
    void error(String msg);
}
