package com.ylb.demoTest.designPattern.Strategy.standardExample;

/**
 * 满300返100，moneyCondition为300，moneyReturn为100
 */
public class CashReturn extends CashSuper {

    private double moneyCondition = 0;
    private double moneyReturn = 0;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money >= moneyCondition){
            // todo 这个逻辑没搞懂
            result = money - Math.floor(money / moneyCondition)*moneyReturn;
        }
        return result;
    }
}
