package io.netty.util.internal.logging;

/**
 * Created by jianchanglun on 2015/5/12.
 */
public abstract class InternalLoggerFactory {

    private static InternalLoggerFactory newDefaultFactory(String name){
        InternalLoggerFactory f;

        try{
            f = new Slf4JLoggerFactory(true);
            f.newInstance(name).debug("Using SLF4J as the default logging framework");
        }catch(Throwable t1){
           try {
               f = new Log4JLoggerFactory();
               f.newInstance(name).debug("Using Log4j as the default logging framework");
           }catch (Throwable t2){
               f = new JdkLoggerFactory();
               f.newInstance(name).debug("Using java.util.logging as the default logging framework");
           }
        }
        return f;
    }

    protected abstract InternalLogger newInstance(String name);

}
