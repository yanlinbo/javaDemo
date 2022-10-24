package com.ylb.demoTest.designPattern.builder;

public class Client {

    public static void main(String[] args) {
        ConreteComponent c = new ConreteComponent();
        ConcreteComponentA a = new ConcreteComponentA();
        ConcreteComponentB b = new ConcreteComponentB();
        a.setComponent(c);
        b.setComponent(a);
        b.operation();
    }

}
