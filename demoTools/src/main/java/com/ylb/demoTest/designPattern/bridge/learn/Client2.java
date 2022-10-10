package com.ylb.demoTest.designPattern.bridge.learn;

import com.ylb.demoTest.designPattern.bridge.learn.abstraction.AHouseCorp;
import com.ylb.demoTest.designPattern.bridge.learn.abstraction.ShanZhaiCorp;
import com.ylb.demoTest.designPattern.bridge.learn.implementor.Clothes;
import com.ylb.demoTest.designPattern.bridge.learn.implementor.House;

public class Client2 {

    public static void main(String... args) {
        House house = new House();
        System.out.println("-------房地产公司是这个样子运行的-------");
        //先找到我的公司
        AHouseCorp houseCorp = new AHouseCorp(house);
        //看我怎么挣钱
        houseCorp.makeMoney();
        System.out.println("\n");
        //山寨公司生产的产品很多，不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new Clothes());
        //ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
