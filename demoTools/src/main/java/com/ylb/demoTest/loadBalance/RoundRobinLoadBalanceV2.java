package com.ylb.demoTest.loadBalance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundRobinLoadBalanceV2 {

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
    // 当前循环的位置
    private static Integer pos = 0;
    public static String getServer() {
        int totalWeight = 0;
        boolean sameWeight = true; // 如果所有权重都相等，那么随机一个ip就好了
        Object[] weights = WEIGHT_LIST.values().toArray();
        for (int i = 0; i < weights.length; i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;
            if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
                sameWeight = false;
            }
        }
        Integer sequenceNum = new Sequence().getAndIncrement();
        Integer offset = sequenceNum % totalWeight;
        offset = offset == 0 ?  totalWeight : offset;
        if(!sameWeight){
            for (String ip : WEIGHT_LIST.keySet()) {
                Integer weight = WEIGHT_LIST.get(ip);
                if (offset <= weight) {
                    return ip;
                }
                offset = offset - weight;
            }
        }
        String ip = null;
        synchronized (pos) {
            if (pos >= LIST.size()) {
                pos = 0;
            }
            ip = LIST.get(pos);
            pos++;
        }
        return ip;
    }

    /**
     * todo:思考一下，内部内中的为什么不能用static？
     */
    static class Sequence{
        public Integer num = 0;
        public Integer getAndIncrement(){
           return num++;
        }
    }

    public static void main(String[] args) {
        // 连续调用10次
        for (int i = 0; i < 1000; i++) {
            System.out.println(getServer());
        }
    }
}
