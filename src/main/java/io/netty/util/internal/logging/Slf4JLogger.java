package io.netty.util.internal.logging;

import org.slf4j.Logger;

/**
 * Created by jianchanglun on 2015/5/22.
 */
public class Slf4JLogger extends AbstractInternalLogger {


    private static final long serialVersionUID = -6717167746566210558L;

    private final transient Logger logger;

    Slf4JLogger(Logger logger){
        super(logger.getName());
        this.logger = logger;
    }

    public boolean isTraceEnabled(){
        return logger.isTraceEnabled();
    }

    public void trace(String msg){
        logger.trace(msg);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void warn(String msg){
        logger.warn(msg);
    }

    public void warn(String msg, Throwable e){
        logger.warn(msg,e);
    }

}
