package io.netty.util.internal.logging;

import java.io.Serializable;

/**
 * Created by jianchanglun on 2015/5/13.
 */
public abstract class AbstractInternalLogger implements InternalLogger,Serializable {

    private static final long serialVersionUID = 2256580984621800644L;

    private final String name;

    protected AbstractInternalLogger(String name){
        if(name == null){
            throw new NullPointerException("name");
        }
        this.name = name;
    }

    public String name(){
        return name;
    }

}
