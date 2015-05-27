package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public final class PlatformDependent {

    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PlatformDependent.class);
    private static final int JAVA_VERSION = javaVersion0();
    private static final boolean IS_ANDROID = isAndroid0();
    private static final boolean HAS_UNSAFE = hasUnsafe0();
   private static final boolean CAN_USE_CHM_V8 = HAS_UNSAFE && JAVA_VERSION<8;


    private static boolean hashUnsafe(){
        boolean noUnsafe = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        logger.debug("-Dio.netty.noUnsafe: {} ", noUnsafe);

        if (isAndroid()) {
            logger.debug("sum.misc.Unsafe: unavailable (android)");
            return false;
        }

        if (noUnsafe) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return false;
        }

        boolean tryUnsafe;
        if (SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            tryUnsafe = SystemPropertyUtil.getBoolean("io.netty.tryUnsafe", true);
        } else {
            tryUnsafe = SystemPropertyUtil.getBoolean("org.jboss.netty.tryUnsafe", true);
        }

        if (!tryUnsafe) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.tryUnsafe/org.jboss.netty.tryUnsafe)");
            return false;
        }

        try {
            boolean hasUnsafe = PlatformDependent0.hasUnsafe();
            logger.debug("sun.misc.Unsafe: {}", hasUnsafe ? "available" : "unavailable");
            return hasUnsafe;
        } catch (Throwable t) {
            return false;
        }
    }

    private static boolean hasUnsafe0() {
        boolean noUnsafe = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        logger.debug("-Dio.netty.noUnsafe: {}", noUnsafe);

        if (isAndroid()) {
            logger.debug("sun.misc.Unsafe: unavailable (Android)");
            return false;
        }

        if (noUnsafe) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return false;
        }

        // Legacy properties
        boolean tryUnsafe;
        if (SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            tryUnsafe = SystemPropertyUtil.getBoolean("io.netty.tryUnsafe", true);
        } else {
            tryUnsafe = SystemPropertyUtil.getBoolean("org.jboss.netty.tryUnsafe", true);
        }

        if (!tryUnsafe) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.tryUnsafe/org.jboss.netty.tryUnsafe)");
            return false;
        }

        try {
            boolean hasUnsafe = PlatformDependent0.hasUnsafe();
            logger.debug("sun.misc.Unsafe: {}", hasUnsafe ? "available" : "unavailable");
            return hasUnsafe;
        } catch (Throwable t) {
            // Probably failed to initialize PlatformDependent0.
            return false;
        }
    }

    public static ClassLoader getClassLoader(final Class<?> clazz) {
        return PlatformDependent0.getClassLoader(clazz);
    }

    private static boolean isAndroid0(){
        boolean android;
        try {
             Class.forName("android.app.Application",false, getSystemClassLoader());
            android = true;
        }catch(Exception e) {
            android = false;
        }

        if(android){
            logger.debug("Platform : android");
        }
        return android;
    }

    private static int javaVersion0() {
        int javaVersion;

        for (;;) {

            if (isAndroid()) {
                javaVersion = 6;
                break;
            }

            try {
                Class.forName("java.time.Clock", false, getClassLoader(Object.class));
                javaVersion = 8;
                break;
            } catch (Exception e) {

            }

            try {
                Class.forName("java.util.concurrent.LinkedTransferQueue", false,
                        getClassLoader(BlockingQueue.class));
                javaVersion = 7;
                break;
            } catch (Exception e){

            }

            javaVersion = 6;
            break;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Java version: {}", javaVersion);
        }
        return javaVersion;
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }
}
