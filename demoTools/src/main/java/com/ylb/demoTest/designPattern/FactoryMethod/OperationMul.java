package com.ylb.demoTest.designPattern.FactoryMethod;

public class OperationMul extends Operation {
    @Override
    public double getResult() {

        double result = getNumA() * getNumB();
        return result;
    }
}
