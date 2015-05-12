package io.netty.other;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public class Main {

    @Test
    public void test(){
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

        map.put("str",1);
        Integer va = map.putIfAbsent("str",2);
        System.out.println(va);
    }
}
