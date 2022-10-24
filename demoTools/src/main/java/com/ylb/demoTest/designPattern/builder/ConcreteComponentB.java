package com.ylb.demoTest.designPattern.builder;

public class ConcreteComponentB extends Decorator {
    private String addStatus;
    @Override
    public void operation() {
        super.operation();
        addStatus = "ConcreteComponentB";
        addBehavior();
    }
    private void addBehavior(){
        System.out.println("吃主食喝瓶饮料");
    }
}
