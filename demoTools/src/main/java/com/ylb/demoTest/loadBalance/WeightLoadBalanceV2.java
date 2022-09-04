package com.ylb.demoTest.loadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightLoadBalanceV2 {

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

        //定义一个总权重
       int totalWeight = 0;
       //如果权重相同时，就随机选取一个得了
        boolean sameWeight = true;
        //把每一台机器的权重都放在一个数组中
        Object[] weights = WEIGHT_LIST.values().toArray();

        //遍历权重的个数
        for(int i = 0; i < weights.length; i++){
            //每个权重值是多少
            Integer weight = (Integer) weights[i];
            //获得总权数
            totalWeight += weight;
            //当上一个权重与下一个权重不相同的时候 sameWeight = false  todo:这里有bug
            if(sameWeight && i>0 && weight != weights[i-1] ){
                sameWeight = false;
            }
            //todo:解决bug的写法  想想为什么？
//            if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
//                sameWeight = false;
//            }
        }
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(totalWeight);
        if(!sameWeight){
            //随机去一个权重值，只要小于当前轮到的IP的权重，就选择当前的IP。
            //todo:这一段逻辑没太看懂
            for (String ip : WEIGHT_LIST.keySet()){
                Integer value = WEIGHT_LIST.get(ip);
                if(randomPos < value){
                    return ip;
                }
                randomPos = randomPos-value;
            }
        }
        //如果权重相同时，就从所有服务器中随机选取一个得了
        return (String) WEIGHT_LIST.keySet().toArray()[new java.util.Random().nextInt(WEIGHT_LIST.size())];
    }

    public static void main(String[] args) throws InterruptedException {
        //连续调用10次
        for(int i=0; i<10; i++ ){
            Thread.sleep(500);
            System.out.println(getServer());
        }
//        System.out.println(new java.util.Random().nextInt(100));
    }
}
