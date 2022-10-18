package com.ylb.demoTest.designPattern.FactoryMethod;

public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result = getNumA() - getNumB();
        return result;
    }
}
