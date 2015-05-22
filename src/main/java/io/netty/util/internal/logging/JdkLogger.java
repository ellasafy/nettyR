package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by jianchanglun on 2015/5/13.
 */
class JdkLogger extends AbstractInternalLogger {

    private static final long serialVersionUID = -987487572678774681L;

    final transient Logger logger;

    JdkLogger(Logger logger){
        super(logger.getName());
        this.logger = logger;
    }

    public boolean isTraceEnabled(){
        return logger.isLoggable(Level.FINEST);
    }

    private void log(String callerFQCn,Level level, String msg, Throwable t){
        LogRecord record = new LogRecord(level,msg);
        record.setLoggerName(name());
        record.setThrown(t);

    }

    static final String SELF = JdkLogger.class.getName();
    static final String SUPER = AbstractInternalLogger.class.getName();

    private static void fillCallerData(String callerFQCN, LogRecord record){
        StackTraceElement[] steArray = new Throwable().getStackTrace();

        int selfIndex = -1;
        for (int i = 0; i < steArray.length; i++){
            final String className = steArray[i].getClassName();
            if (className.equals(callerFQCN) || className.equals(SUPER)) {
                selfIndex = i;
                break;
            }
        }

        int found = -1;
        for(int i = selfIndex + 1; i < steArray.length; i++){
            final String className = steArray[i].getClassName();
            if (!(className.equals(callerFQCN)) || className.equals(SUPER)) {
                found = i;
                break;
            }
        }

        if (found != -1){
            StackTraceElement ste = steArray[found];
            record.setSourceClassName(ste.getClassName());
            record.setSourceMethodName(ste.getMethodName());
        }
    }

    public void trace(String msg){
        if (logger.isLoggable(Level.FINEST)) {
            log(SELF,Level.FINEST,msg,null);
        }
    }

    public void debug(String msg){
        if(logger.isLoggable(Level.FINE)){
            log(SELF,Level.FINE,msg,null);
        }
    }

    public void warn(String msg){
        if(logger.isLoggable(Level.WARNING)){
            log(SELF,Level.WARNING,msg, null);
        }
    }
    public void warn(String msg, Throwable e){
        if(logger.isLoggable(Level.WARNING)){
            log(SELF,Level.WARNING,msg, e);
        }
    }
}
