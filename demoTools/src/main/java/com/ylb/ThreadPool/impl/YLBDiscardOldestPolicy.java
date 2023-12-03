package com.ylb.ThreadPool.impl;

import com.ylb.ThreadPool.YLBRejectedExecutionHandler;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

/**
 * 如果线程池还在运行中，则丢掉队列中的一个任务，把新任务放进去
 */
public class YLBDiscardOldestPolicy  implements YLBRejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable var1, ThreadPoolExecutor var2) {
        if (!var2.isShutdown()) {
            var2.getQueue().poll();
            var2.execute(var1);
        }
    }
}
