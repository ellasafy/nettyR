package io.netty.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public class Main extends  Ab2{

    public void sort(int[] a, int index){
        if(index == a.length -1){
            return;
        }
        int tmp = a[index];
        for(int i=index+1;i<a.length;i++){
            int[] b = new int[a.length];
            copy(a,b);

        }
    }

    public void print(int[] a){
        for(int i=0;i<a.length -1;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public void copy(int[] a, int[] b) {
        for(int i=0;i<a.length;i++){
            b[i]=a[i];
        }
    }
}
