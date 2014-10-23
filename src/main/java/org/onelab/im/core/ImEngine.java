package org.onelab.im.core;

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
    public static void start(Dependence dependence) throws Exception{
        DependenceRoot.init(dependence);
    }

    /**
     * 停止IM引擎
     */
    public static void stop(){
        Im.destroyDialog();
    }
}
