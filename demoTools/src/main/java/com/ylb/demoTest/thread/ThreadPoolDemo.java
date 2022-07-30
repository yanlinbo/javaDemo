package com.ylb.demoTest.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 比较线程，以及三个线程池执行相同任务的性能
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        Long startTime = System.currentTimeMillis();

        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();

        ExecutorService executorServiceCached = Executors.newCachedThreadPool();
        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(10);
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();

        //快速打出for循环用   fori
        for (int i = 0; i < 10000; i++) {
            //ctrl+alt+v   返回类型和变量的快速补全
//            Thread thread = new Thread(){
//                @Override
//                public void run() {
//                    list.add(random.nextInt());
//                }
//            };
            /**
             * java.util.concurrent.RejectedExecutionException
             */
            executorServiceFixed.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });

//            thread.start();
            executorServiceFixed.shutdown();
            //这一行啥意思？
            executorServiceFixed.awaitTermination(1, TimeUnit.DAYS);
        }
        System.out.println("时间"+(System.currentTimeMillis()));  //时间1659146326999
        System.out.println("大小"+(list.size()));    //大小9962   todo w为啥少了38个？

    }
}
