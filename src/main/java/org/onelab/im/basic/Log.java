package org.onelab.im.basic;


import org.onelab.im.core.dependence.LogInterface;

/**
 * Created by chunliangh on 14-10-21.
 */
public class Log implements LogInterface {
    @Override
    public void debug(String msg, Throwable t) {
        System.out.println("debug:"+msg);
    }

    @Override
    public void info(String msg, Throwable t) {
        System.out.println("info:"+msg);
    }

    @Override
    public void warn(String msg, Throwable t) {
        System.out.println("warn:"+msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        System.out.println("error:"+msg);
    }
}
