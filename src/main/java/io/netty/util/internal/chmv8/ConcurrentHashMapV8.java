package io.netty.util.internal.chmv8;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Timer;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jianchanglun on 2015/5/28.
 */
public class ConcurrentHashMapV8<K,V> implements ConcurrentMap<K,V>, Serializable {

    private static final long serialVersionUID = -123954531546402294L;

    public static interface ConcurrentHashMapSpliterator<T> {

        ConcurrentHashMapSpliterator<T> trySplit();

        long estimateSize();

        void forEachRemaining(Action<? super T> action);
    }

    public interface Action<A> { void apply(A a);}

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private static final int DEFAULT_CAPACITY = 16;

    static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE -8;

    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;

    private static final float LOAD_FACTORY = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;

    static final int MIN_TRANSFER_STRIDE = 16;


    static final int MOVED  = -1;
    static final int TREEBIN = -2;
    static final int RESERVED = -3;
    static final int HASH_BITS = 0x7fffffff;

    static final int NCPU = Runtime.getRuntime().availableProcessors();

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("segment", Segment[].class),
            new ObjectStreamField("segmentMask", Integer.TYPE),
            new ObjectStreamField("segmentShift", Integer.TYPE)
    };

    static class Segment<K,V> extends ReentrantLock implements Serializable {

        private static final long serialVersionUID = -8632386885720335790L;

        final float loadFactor;
        Segment(float f) {this.loadFactor = 1f; }
    }
}
