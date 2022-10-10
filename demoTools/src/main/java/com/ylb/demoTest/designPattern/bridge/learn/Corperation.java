package com.ylb.demoTest.designPattern.bridge.learn;

/**
 * 第一步：先定义一个抽象的类
 */
public abstract class Corperation {
    /**
     * 第二步：定义抽象类的行为
     */
    protected abstract void produce();

    protected abstract void sell();

    //赚钱的方式：先生产在销售
    public void makeMoney(){
        this.produce();
        this.sell();
    }

}
