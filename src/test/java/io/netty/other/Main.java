package io.netty.other;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public class Main extends  Ab2{

   public static void main(String[] args){
       int[] a = new int[]{2,7,11,15};
       ByteBuffer
       int n = 9;

       int i=0;
       int j =a.length -1;

       while(i<j){
           if(a[i] + a[j] > n){
               j--;
           }else if(a[i] + a[j] <n){
               i++;
           }else{
               break;
           }

       }
       System.out.println(i + " " + j);
   }
}
