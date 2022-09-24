package com.ylb.demoTest.designPattern.bridge;

/**
 * 管理这两家公司
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("-------房地产公司是这个样子运行的-------");
        Corperation houseCorp = new HouseCorp();
        houseCorp.makeMoney();
        System.out.println("\n");

        System.out.println("-------服装公司是这样运行的-------");
        Corperation clothsCorp = new ClothsCorp();
        clothsCorp.makeMoney();
    }
}
