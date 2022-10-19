package com.ylb.demoTest.designPattern.Strategy.standard;

public class Context {
    Strategy strategy;

    /**
     *
     * @param concreteStrategy  构造函数入参为具体的策略
     */
    public Context(Strategy concreteStrategy){
        this.strategy = concreteStrategy;
    }

    /**
     * 调用具体策略算法
     */
    public void conmtextInteface(){
        strategy.algorithmInteface();
    }
}
