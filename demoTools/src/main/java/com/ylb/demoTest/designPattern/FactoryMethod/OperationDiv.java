package com.ylb.demoTest.designPattern.FactoryMethod;

public class OperationDiv extends Operation {
    @Override
    public double getResult() throws Exception {
        if(getNumB() == 0){
            throw new Exception("除数不能为0");
        }
        double result = getNumA()/getNumB();
        return result;
    }
}
