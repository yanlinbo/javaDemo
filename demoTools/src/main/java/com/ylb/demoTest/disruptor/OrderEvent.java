package com.ylb.demoTest.disruptor;


public class OrderEvent {
    private long value;
    private String name;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
