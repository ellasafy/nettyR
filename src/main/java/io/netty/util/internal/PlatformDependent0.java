package io.netty.util.internal;

import java.util.HashMap;

/**
 * Created by jianchanglun on 2015/5/22.
 */
public class PlatformDependent0 {

    /**
     *
     * @return
     */
    static ClassLoader getSystemClassLoader() {

        HashMap
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
    }
}
