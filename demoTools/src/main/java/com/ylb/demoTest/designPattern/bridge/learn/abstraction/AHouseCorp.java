package com.ylb.demoTest.designPattern.bridge.learn.abstraction;

import com.ylb.demoTest.designPattern.bridge.learn.implementor.Product;

public class AHouseCorp extends ACorperation {
    public AHouseCorp(Product product) {
        super(product);
    }

    //公司是干什么的？赚钱的呀，不赚钱傻子才干
    public void makeMoney(){

        super.makeMoney();
        System.out.println("房地产公司赚大钱了");
    }
}
