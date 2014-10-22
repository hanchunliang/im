package org.onelab.im.core;

/**
 * Created by chunliangh on 14-10-21.
 */
public class Im {

    /**
     * 初始化IM引擎
     * @param dependence 外部依赖。null表示使用IM引擎提供的默认依赖
     * @throws Exception
     */
    public static void init(Dependence dependence) throws Exception{
        Root.init(dependence);
    }

    /**
     * 停止IM引擎
     */
    public static void destroy(){}

}
