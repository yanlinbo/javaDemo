package com.ylb.demoTest.designPattern.simpleFactory;


public class Operation {
    private double numA = 0;
    private double numB = 0;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public double getResult() throws Exception {
        double result = 0;
        return result;
    }
}
