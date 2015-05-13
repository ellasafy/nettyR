package io.netty.util.internal.logging;

import java.util.logging.Logger;

/**
 * Created by jianchanglun on 2015/5/13.
 */
public class JdkLoggerFactory extends InternalLoggerFactory {

    public InternalLogger newInstance(String name){
        return new JdkLogger(Logger.getLogger(name));
    }
}
