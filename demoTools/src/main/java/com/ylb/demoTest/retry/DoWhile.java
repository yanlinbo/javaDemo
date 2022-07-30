package com.ylb.demoTest.retry;

/**
 *第二种：自定义，对重试的条件和次数做了控制
 */
public class DoWhile {
    public static void main(String[] args) {
        //定义重试的最大次数
        int maxRetryTime = 5;
        //执行的次数
        int executeTime = 0;
        //重试逻辑的返回结果
        String result = null;
        do{
            executeTime++;
            try{
                result = testRedo();
            }catch(Exception e){
                e.printStackTrace();
            }
        }while (null == result && executeTime < maxRetryTime);

    }

    private static String  testRedo(){
        System.out.println("执行重试代码"); //重试逻辑
        return null;
    }
}
