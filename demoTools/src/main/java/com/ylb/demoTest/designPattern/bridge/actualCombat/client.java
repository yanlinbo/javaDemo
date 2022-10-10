package com.ylb.demoTest.designPattern.bridge.actualCombat;

public class client {

    public static void main(String[] args) {
        System.out.println("开始调用21050交易");
        BGLtrander trander21051 = new Trander21051();
        trander21051.excutorTrander();

        System.out.println("\n");

        System.out.println("开始调用21150交易");
        BGLtrander trander21151 = new Trander21051();
        trander21151.excutorTrander();
    }
}
