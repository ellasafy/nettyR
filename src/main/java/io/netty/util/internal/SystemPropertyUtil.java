package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jianchanglun on 2015/5/22.
 */
public class SystemPropertyUtil {

    private static boolean initializedLogger;
    private static final InternalLogger logger;
    private static boolean loggedException;

    static {
        initializedLogger = false;
        logger = InternalLoggerFactory.getInstance(SystemPropertyUtil.class);
        initializedLogger = true;
    }
    public static boolean getBoolean(String key, boolean def){
        String value= get(key);
        if (value == null) {
            return def;
        }

        value = value.trim().toLowerCase();
        if (value.isEmpty()){
            return true;
        }

        if ("true".equals(value) || "yes".equals(value) || "1".equals(value)) {
            return true;
        }

        if ("false".equals(value) || "no".equals(value) || "0".equals(value)){
            return false;
        }

        log(
                "Unable to parse the boolean system property '" + key + "':" + value + " - " +
                        "using the default value: " + def);

        return def;
    }

    public static String get(String key){
        return get(key, null);
    }

    public static String get(final String key, String def){
        if (key == null){
            throw new NullPointerException("key");
        }

        if(key.isEmpty()){
            throw new IllegalArgumentException("key must not be empty");
        }

        String value = null;
        try {
             if(System.getSecurityManager() == null){
                 value = System.getProperty(key);
             } else {
                 value = AccessController.doPrivileged(new PrivilegedAction<String>(){
                    public String run() {
                        return System.getProperty(key);
                    }
                 });
             }
        }catch(Exception e){
             if (!loggedException) {
                 log("Unable to retrive a system property '" + key + "';default values will be used.",e);
                 loggedException = true;
             }
        }

        if(value == null){
            return def;
        }
        return value;
    }
    private static void log(String msg, Exception e){
        if (initializedLogger) {
            logger.warn(msg,e);
        } else {
            Logger.getLogger(SystemPropertyUtil.class.getName()).log(Level.WARNING,msg,e);
        }
    }
    private static void log(String msg){
        if (initializedLogger) {
            logger.warn(msg);
        } else {
            Logger.getLogger(SystemPropertyUtil.class.getName()).log(Level.WARNING,msg);
        }
    }
}
