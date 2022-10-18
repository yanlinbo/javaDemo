package com.ylb.demoTest.designPattern.simpleFactory;

public class OperationMul extends Operation {
    @Override
    public double getResult() {

        double result = getNumA() * getNumB();
        return result;
    }
}
