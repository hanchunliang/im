package org.onelab.im.core;

import org.onelab.im.core.domain.Dependence;
import org.onelab.im.core.domain.DependenceRoot;

/**
 * IM引擎
 * Created by chunliangh on 14-10-22.
 */
public class ImEngine {
    /**
     * 开启IM引擎
     * @param dependence 外部依赖。null表示使用IM引擎提供的默认依赖
     * @throws Exception
     */
    public static void start(Dependence dependence){
        try {
            DependenceRoot.init(dependence);
        } catch (Throwable t){
            DependenceRoot.dialogLog.error("fail to start ImEngine",t);
            throw new RuntimeException("fail to start ImEngine",t);
        }
        DependenceRoot.dialogLog.info("start ImEngine success....");
    }

    /**
     * 停止IM引擎
     */
    public static void stop() throws Exception{
        try {
            Im.destroyDialog();
        } catch (Throwable t){
            DependenceRoot.dialogLog.error("fail to stop ImEngine",t);
            throw new RuntimeException("fail to stop ImEngine",t);
        }
        DependenceRoot.dialogLog.info("stop ImEngine success....");
    }
}
