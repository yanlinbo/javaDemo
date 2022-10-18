package com.ylb.demoTest.designPattern.FactoryMethod;

public class Client {
    public static void main(String[] args) throws Exception {

        IFactory factory = new AddFactory();
        Operation operation = factory.CreateOperation();
        operation.setNumA(5);
        operation.setNumB(2);
        double result = operation.getResult();
        System.out.println(result);
    }
}
