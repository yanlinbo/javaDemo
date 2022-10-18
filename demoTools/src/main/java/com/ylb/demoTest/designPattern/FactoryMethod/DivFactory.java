package com.ylb.demoTest.designPattern.FactoryMethod;

public class DivFactory implements IFactory {
    @Override
    public Operation CreateOperation() {
        return new OperationDiv();
    }
}
