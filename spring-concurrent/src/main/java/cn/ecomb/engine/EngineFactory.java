package cn.ecomb.engine;

import java.util.concurrent.*;

/**
 * 配置出不同的引擎
 *
 * @author zhouzg
 * @date 2018/12/26
 */
public class EngineFactory {

    private int threadNum;
    private int maxPoolSize;
    ExecutorService executor = Executors.newFixedThreadPool(threadNum);
    ExecutorService executors = new ThreadPoolExecutor(0,
            maxPoolSize,
            60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());



}
