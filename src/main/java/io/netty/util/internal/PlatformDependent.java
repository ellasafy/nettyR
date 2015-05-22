package io.netty.util.internal;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public final class PlatformDependent {

    private static final int JAVA_VERSION = javaVersion0();

   private static final boolean CAN_USE_CHM_V8 = HAS_UNSAFE && JAVA_VERSION<8;


    private static boolean hashUnsafe(){
        boolean noUnsafe = SystemPropertyUtil.getBoolean()
    }

    private static boolean isAndroid0(){
        boolean android;
        try {

        }catch(Exception e) {

        }
    }
}
