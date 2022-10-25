package com.ylb.demoTest.designPattern.composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void addComponent(Component component);

    public abstract void removeComponent(Component component);

    public abstract void display(int depth);
}
