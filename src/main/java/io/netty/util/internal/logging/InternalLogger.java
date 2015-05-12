package io.netty.util.internal.logging;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public interface InternalLogger {

    String name();

    boolean isTraceEnabled();

    void trace(String msg);


}