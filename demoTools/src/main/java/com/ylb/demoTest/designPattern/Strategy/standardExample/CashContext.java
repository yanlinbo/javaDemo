package com.ylb.demoTest.designPattern.Strategy.standardExample;

public class CashContext {
    CashSuper cashSuper;
    public CashContext(String type){
        switch (type){
            case "namal":
                cashSuper = new CashNormal();
                break;
            case "rebate":
                cashSuper = new CashRebate(0.8);
                break;
            case "return":
                cashSuper = new CashReturn(300,100);
                break;
            default:
                cashSuper = new CashNormal();
                break;
        }
    }

    public double getResult(double money){
        return cashSuper.acceptCash(500);
    }
}
