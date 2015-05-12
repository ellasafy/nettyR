package io.netty.util.internal;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public final class ObjectUtil {
    private ObjectUtil(){}

    public static <T> T checkNotNull(T arg, String text){
        if(arg == null){
            throw new NullPointerException(text);
        }
        return arg;
    }
}
