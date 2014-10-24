package org.onelab.im.basic;


import org.onelab.im.dependence.DialogLogInterface;

import java.util.logging.Logger;

/**
 * Created by chunliangh on 14-10-21.
 */
public class DialogLog implements DialogLogInterface {

    Logger logger = Logger.getLogger("<<im log>>");

    @Override
    public void info(String msg) {
        logger.info(msg);
    }

    @Override
    public void warn(String msg) {
        logger.warning(msg);
    }

    @Override
    public void error(String msg) {
        logger.severe(msg);
    }
}
