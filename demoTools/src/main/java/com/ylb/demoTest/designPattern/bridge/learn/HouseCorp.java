package com.ylb.demoTest.designPattern.bridge.learn;

/**
 * 第三步：定义具体的赚钱公司：房地产公司
 */
public class HouseCorp extends Corperation {
    @Override
    protected void produce() {
        System.out.println("房地产公司盖房子...");
    }

    @Override
    protected void sell() {
        System.out.println("房地产公司出售房子...");
    }

    /**
     * 对赚钱的方式进行重写
     */
    public void makeMoney(){
        super.makeMoney();
        System.out.println("房地产挣钱了");
    }
}
