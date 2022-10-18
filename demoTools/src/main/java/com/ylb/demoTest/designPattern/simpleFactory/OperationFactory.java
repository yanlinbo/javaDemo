package com.ylb.demoTest.designPattern.simpleFactory;


public class OperationFactory {

    /**
     * todo 这里为什么要用静态方法？
     * @param operate
     * @return
     */
    public static Operation createOperate(String operate){
        Operation operation = null;
        switch(operate){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                break;
        }
        return operation;
    }
}
