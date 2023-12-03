package com.ylb.ThreadPool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

/**
 * 线程池的拒绝策略
 */
public interface YLBRejectedExecutionHandler {

    void rejectedExecution(Runnable var1, ThreadPoolExecutor var2);
}
