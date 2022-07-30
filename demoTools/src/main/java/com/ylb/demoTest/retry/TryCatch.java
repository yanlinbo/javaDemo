package com.ylb.demoTest.retry;

/**
 * 第一种：重试的雏形,出现异常就重试（一次）
 */
public class TryCatch {

    public static void main(String[] args) {
        try{
            testRedo();
        }catch(Exception e){
            testRedo();
            e.printStackTrace();
        }

    }
    private static void testRedo(){
        System.out.println("执行重试代码"); //重试逻辑
        throw new RuntimeException();
    }
}
