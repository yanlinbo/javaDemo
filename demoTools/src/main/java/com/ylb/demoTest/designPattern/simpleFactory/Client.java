package com.ylb.demoTest.designPattern.simpleFactory;

public class Client {
    public static void main(String[] args) throws Exception {
        Operation oper = null;
//        oper = new OperationAdd();
        oper  = OperationFactory.createOperate("*");
        oper.setNumA(5);
        oper.setNumB(2);
        double result = oper.getResult();
        System.out.println(result);
    }
}
