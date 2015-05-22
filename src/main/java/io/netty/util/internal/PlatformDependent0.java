package io.netty.util.internal;

/**
 * Created by jianchanglun on 2015/5/22.
 */
public class PlatformDependent0 {

    /**
     *
     * @return
     */
    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
    }
}
