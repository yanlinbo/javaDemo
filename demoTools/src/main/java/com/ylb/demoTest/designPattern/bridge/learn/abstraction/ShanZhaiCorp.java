package com.ylb.demoTest.designPattern.bridge.learn.abstraction;

import com.ylb.demoTest.designPattern.bridge.learn.implementor.Product;

public class ShanZhaiCorp extends ACorperation {
    public ShanZhaiCorp(Product product) {
        super(product);
    }

    //公司是干什么的？赚钱的呀，不赚钱傻子才干
    public void makeMoney(){

        super.makeMoney();
        System.out.println("山寨当前最热门的产品赚钱");
    }
}
