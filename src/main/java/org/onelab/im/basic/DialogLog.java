package org.onelab.im.basic;


import org.onelab.im.dependence.DialogLogInterface;

/**
 * Created by chunliangh on 14-10-21.
 */
public class DialogLog implements DialogLogInterface {

    @Override
    public void info(String msg) {
        System.out.println("info:"+msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("warn:"+msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        System.out.println("error:"+msg);
    }
}
