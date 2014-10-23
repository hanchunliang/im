package org.onelab.im.dependence;

import org.onelab.im.core.Dialog;

import java.util.List;

/**
 * 数据库访问接口，需外部提供实现。
 * 需要提供默认无参构造子
 * Created by chunliangh on 14-10-20.
 */
public interface DialogPersistenceInterface {
    int persist(Dialog dialog);
    int persist(List<Dialog> dialogs);
}
