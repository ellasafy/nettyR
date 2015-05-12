package io.netty.util;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

/**
 * Created by ellsasa on 2015/5/8.
 */
public class UniqueName implements Comparable<UniqueName> {
    private static final AtomicInteger nextId = new AtomicInteger();

    private final int id;
    private final String name;

    public UniqueName(ConcurrentMap<String, Boolean> map, String name, Object... args){
        checkNotNull(map,"map");

        if(args != null && args.length >0){
            validateArgs(args);
        }

        if(map.putIfAbsent(name,Boolean.TRUE) != null){
            throw new IllegalArgumentException(String.format("'%s' is already in use",name));
        }
        this.name = checkNotNull(name,"name");
        id=nextId.incrementAndGet();

    }

    protected UniqueName(String name){
        this.name = checkNotNull(name, "name");
        id = nextId.incrementAndGet();
    }


    protected void validateArgs(Object... args){

    }

    public final String name() {
        return name;
    }

    public final int id() {
        return id;
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object o){
        return super.equals(o);
    }

    public int compareTo(UniqueName other){
        if(this == other){
            return 0;
        }

        int returnCode = name.compareTo(other.name);
        if (returnCode != 0) {
            return returnCode;
        }

        return ((Integer)id).compareTo(other.id);
    }

    @Override
    public String toString() {
        return name();
    }
}
