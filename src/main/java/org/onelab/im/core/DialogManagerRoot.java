package org.onelab.im.core;

import org.onelab.im.core.domain.manager.DialogGlobalManager;
import org.onelab.im.core.domain.manager.DialogLifeCycleManager;
import org.onelab.im.core.domain.manager.DialogMonitorManager;
import org.onelab.im.core.domain.manager.DialogPanelManager;

/**
 * Created by chunliangh on 14-10-22.
 */
public class DialogManagerRoot {
    static DialogGlobalManager global = new DialogGlobalManager();
    static DialogLifeCycleManager lifeCycle = new DialogLifeCycleManager();
    static DialogMonitorManager monitor = new DialogMonitorManager();
    static DialogPanelManager panel = new DialogPanelManager();
}
