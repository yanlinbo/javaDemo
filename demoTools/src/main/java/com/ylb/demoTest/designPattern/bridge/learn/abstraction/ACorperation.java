package com.ylb.demoTest.designPattern.bridge.learn.abstraction;

import com.ylb.demoTest.designPattern.bridge.learn.implementor.Product;

/**
 * 把公司和产品的属性隔离开来
 *  公司就是用来挣钱的
 *  产品的生产与销售归属产品的属性
 */
public abstract class ACorperation {

    //定义一个产品对象，抽象的了，不知道具体是什么产品
    private Product product;

    public ACorperation(Product product) {
        this.product = product;
    }

    //公司是干什么的？赚钱的呀，不赚钱傻子才干
    public void makeMoney(){

        //每个公司都是一样，先生产
        this.product.beProducted();

        //然后销售
        this.product.beSelled();
    }

}
