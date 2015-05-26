package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public final class PlatformDependent {

    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PlatformDependent.class);
    private static final int JAVA_VERSION = javaVersion0();

   private static final boolean CAN_USE_CHM_V8 = HAS_UNSAFE && JAVA_VERSION<8;


    private static boolean hashUnsafe(){
        boolean noUnsafe = SystemPropertyUtil.getBoolean()
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

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }
}
