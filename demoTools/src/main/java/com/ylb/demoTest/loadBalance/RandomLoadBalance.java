package com.ylb.demoTest.loadBalance;

import java.util.Arrays;
import java.util.List;

public class RandomLoadBalance {

    /**
     * 随机
     */
    public static final List<String> LIST = Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10");

    public static String getServer(){
        //生成一个随机数作为list的下标志
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(LIST.size());
        return LIST.get(randomPos);
    }

    public static void main(String[] args) throws InterruptedException {
        //连续调用10次
        for(int i=0; i<LIST.size(); i++ ){
            Thread.sleep(1000);
            System.out.println(getServer());
        }
    }
}
