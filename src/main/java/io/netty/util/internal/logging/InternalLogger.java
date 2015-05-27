package io.netty.util.internal.logging;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public interface InternalLogger {

    String name();

    boolean isTraceEnabled();

    boolean isDebugEnabled();

    void trace(String msg);
    void debug(String msg);
    void debug(String format, Object arg);


    void warn(String msg);
    void warn(String msg, Throwable t);
}
