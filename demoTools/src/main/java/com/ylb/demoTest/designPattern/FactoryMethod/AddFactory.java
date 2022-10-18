package com.ylb.demoTest.designPattern.FactoryMethod;

public class AddFactory implements IFactory {
    @Override
    public Operation CreateOperation() {
        return new OperationAdd();
    }
}
