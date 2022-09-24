package com.ylb.demoTest.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            //这行代码的意思是等待上面10万个线程跑完
            thread.join();
        }
        System.out.println("时间：" + (System.currentTimeMillis()-start));
        System.out.println("大小：" + list.size());
    }
}
