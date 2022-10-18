package com.ylb.demoTest.designPattern.simpleFactory;

public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        double result = getNumA() + getNumB();
        return result;
    }
}
