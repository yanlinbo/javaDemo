package com.ylb.demoTest.designPattern.bridge.learn;

public class ClothsCorp extends Corperation {
    @Override
    protected void produce() {
        System.out.println("服装公司生产衣服...");
    }

    @Override
    protected void sell() {
        System.out.println("服装公司出售衣服...");
    }

    /**
     * 对赚钱的方式进行重写
     */
    public void makeMoney(){
        super.makeMoney();
        System.out.println("服装厂地挣钱了");
    }
}
