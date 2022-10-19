package com.ylb.demoTest.designPattern.Strategy.standardExample;

public class Client {

    public static void main(String[] args) {
        CashContext cashContext = new CashContext("return");
        double result = cashContext.getResult(800);
        System.out.println(result);
    }

}
