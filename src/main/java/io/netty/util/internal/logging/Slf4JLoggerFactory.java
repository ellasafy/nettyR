package io.netty.util.internal.logging;


import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    public Slf4JLoggerFactory(){}

    Slf4JLoggerFactory(boolean failIfNOP){
        assert failIfNOP;

        final StringBuffer buf = new StringBuffer();
        final PrintStream err = System.err;
        try{
           System.setErr(new PrintStream(new OutputStream(){

               @Override
               public void write(int b){
                   buf.append((char)b);
               }
           }, true, "US-ASCII"));
        }catch(UnsupportedEncodingException e){
            throw new Error(e);
        }

        try {
            if(LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory){
                throw new NoClassDefFoundError(buf.toString());
            }else{
                err.print(buf);
                err.flush();
            }
        }finally {
            System.setErr(err);
        }
    }


}
