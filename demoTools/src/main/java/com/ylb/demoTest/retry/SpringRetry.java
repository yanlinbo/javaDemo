package com.ylb.demoTest.retry;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * 第三种：spring提供的retry机制
 */
public class SpringRetry {

    public static void main(String[] args) throws Throwable {
        final String params = "传入参数,可为任意类型，final修饰即可";
        // 重试机制
        RetryTemplate oRetryTemplate = new RetryTemplate();
        SimpleRetryPolicy oRetryPolicy = new SimpleRetryPolicy();
        oRetryPolicy.setMaxAttempts(5);
        oRetryTemplate.setRetryPolicy(oRetryPolicy);

        try{
            Object execute = oRetryTemplate.execute(new RetryCallback<Object, Throwable>() {
                @Override
                public Object doWithRetry(RetryContext retryContext) throws Throwable {
                    System.out.println(params);
                    testRedo();
                    return "返回操作结果";
                }
            }, new RecoveryCallback<Object>() {
                @Override
                public Object recover(RetryContext retryContext) throws Exception {
                    return null;
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private static void testRedo() {
        System.out.println("执行Redo代码");
        throw new RuntimeException();
    }
}
