package io.netty.util.internal.logging;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by jianchanglun on 2015/5/13.
 */
public class Log4JLogger extends AbstractInternalLogger {

    private static final long serialVersionUID = -3937775213492555522L;

    final transient Logger logger;

    static final String FQCN = Log4JLogger.class.getName();

    final boolean traceCapable;

    Log4JLogger(Logger logger){
        super(logger.getName());
        this.logger = logger;
        traceCapable = isTraceCapable();
    }

    private boolean isTraceCapable() {
        try {
            logger.isTraceEnabled();
            return true;
        }catch(NoSuchMethodError ignored){
            return false;
        }
    }

    public boolean isTraceEnabled() {
        if (traceCapable){
            return logger.isTraceEnabled();
        } else {
            return logger.isDebugEnabled();
        }
    }

    public void debug(String msg){
        logger.log(FQCN, Level.DEBUG,msg,null);
    }

    public void trace(String msg){
        logger.log(FQCN, traceCapable?Level.TRACE:Level.DEBUG,msg,null);
    }

    public void warn(String msg){
        logger.log(FQCN, Level.WARN,msg,null);
    }
    public void warn(String msg,Throwable e){
        logger.log(FQCN, Level.WARN,msg,e);
    }
}
