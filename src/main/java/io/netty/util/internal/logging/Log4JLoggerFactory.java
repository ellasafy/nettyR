package io.netty.util.internal.logging;


import org.apache.log4j.Logger;

/**
 * Created by jianchanglun on 2015/5/13.
 */
public class Log4JLoggerFactory extends InternalLoggerFactory {

   public InternalLogger newInstance(String name) {
       return new Log4JLogger(Logger.getLogger(name));
   }
}
