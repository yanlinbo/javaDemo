package com.ylb.demoTest.designPattern.proxy;

/**
 * 代理类的逻辑需要多想想，比较绕
 */
public class Proxy implements GiveGift{

    Pursuit pursuit;

    /**
     * todo 思考一下这个方法：表面看是代理类送礼物，实际是真正的追求者送礼物
     * @param schoolGirl
     */
    public Proxy(SchoolGirl schoolGirl) {
        pursuit = new Pursuit(schoolGirl);
    }

    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
