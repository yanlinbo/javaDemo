package com.ylb.ThreadPool.impl;

import com.ylb.ThreadPool.YLBRejectedExecutionHandler;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

/**
 * 如果线程池还在运行，优先执行该任务
 */
public class YLBCallerRunsPolicy implements YLBRejectedExecutionHandler {
    public YLBCallerRunsPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable var1, ThreadPoolExecutor var2) {
        if(!var2.isShutdown()){
            var1.run();
        }
    }
}
