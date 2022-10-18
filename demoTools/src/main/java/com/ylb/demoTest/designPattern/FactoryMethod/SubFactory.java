package com.ylb.demoTest.designPattern.FactoryMethod;

public class SubFactory implements IFactory {
    @Override
    public Operation CreateOperation() {
        return new OperationSub();
    }
}
