package com.ylb.demoTest.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadDemo {

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();

        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();
        //快速打出for循环用   fori
        for (int i = 0; i < 10000; i++) {
            //ctrl+alt+v   返回类型和变量的快速补全
            Thread thread = new Thread(){
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
        }
        System.out.println("时间"+(System.currentTimeMillis()));  //时间1659146326999

    }
}
