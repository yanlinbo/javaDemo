package com.ylb.demoTest.loadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightLoadBalanceV1 {

    /**
     * 权重随机
     */
    public static final Map<String,Integer> WEIGHT_LIST = new HashMap<>();
    static {
        // 权重之和为50
        WEIGHT_LIST.put("192.168.0.1", 1);
        WEIGHT_LIST.put("192.168.0.2", 8);
        WEIGHT_LIST.put("192.168.0.3", 3);
        WEIGHT_LIST.put("192.168.0.4", 6);
        WEIGHT_LIST.put("192.168.0.5", 5);
        WEIGHT_LIST.put("192.168.0.6", 5);
        WEIGHT_LIST.put("192.168.0.7", 4);
        WEIGHT_LIST.put("192.168.0.8", 7);
        WEIGHT_LIST.put("192.168.0.9", 2);
        WEIGHT_LIST.put("192.168.0.10", 9);
    }

    public static String getServer(){
        // 生成一个随机数作为list的下标值
        List<String> ips = new ArrayList<>();
        //遍历IP地址  所谓权重的本质就是把权重高的IP在集合中出现的次数高一点而已，然后在进行随机
        for(String ip : WEIGHT_LIST.keySet()){
            Integer weight = WEIGHT_LIST.get(ip);
                for(int i=0; i<weight; i++){
                    ips.add(ip);
                }
        }
        //按比例让权重高的IP在集合中放的多一点，然后再在集合中随机选取
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(ips.size());
        return ips.get(randomPos);
    }

    public static void main(String[] args) throws InterruptedException {
        //连续调用10次
        for(int i=0; i<100; i++ ){
            Thread.sleep(1000);
            System.out.println(getServer());
        }
    }
}
