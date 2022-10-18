package com.ylb.demoTest.designPattern.simpleFactory;

public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result = getNumA() - getNumB();
        return result;
    }
}
