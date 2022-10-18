package com.ylb.demoTest.designPattern.proxy;

public class Client {

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("gengyun");
        Proxy proxy = new Proxy(schoolGirl);

        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();
    }

}
