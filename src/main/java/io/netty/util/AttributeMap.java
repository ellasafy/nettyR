package io.netty.util;

/**
 * Created by ellsasa on 2015/5/7.
 */
public interface AttributeMap {

    <T> Attribute<T> attr(AttributeKey<T> key);
}
