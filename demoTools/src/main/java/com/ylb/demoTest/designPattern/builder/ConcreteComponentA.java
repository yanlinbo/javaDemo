package com.ylb.demoTest.designPattern.builder;

public class ConcreteComponentA extends Decorator {
    private String addStatus;
    @Override
    public void operation() {
        super.operation();
        addStatus = "ConcreteComponentA";
        System.out.println("吃主食加个小菜");
    }


}
