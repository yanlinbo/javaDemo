package com.ylb.demoTest.designPattern.Strategy.standardExample;

public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
