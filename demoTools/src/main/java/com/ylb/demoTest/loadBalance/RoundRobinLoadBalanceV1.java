package com.ylb.demoTest.loadBalance;

import java.util.Arrays;
import java.util.List;

public class RoundRobinLoadBalanceV1 {

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
    // 当前循环的位置
    private static Integer pos = 0;
    public static String getServer() {

        String ip = null;
        synchronized(pos){
            if(pos >= LIST.size()){
                pos = 0;
            }
            ip = LIST.get(pos);
            pos++;
        }
        return ip;
    }

    public static void main(String[] args) {
        // 连续调用10次
        for (int i = 0; i < 11; i++) {
            System.out.println(getServer());
        }
    }
}
