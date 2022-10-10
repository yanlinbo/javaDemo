package com.ylb.demoTest.designPattern.bridge.actualCombat;

public class Trander21151 extends BGLtrander{
    @Override
    protected boolean buildContext() {
        System.out.println("构建21151的上下文");
        return false;
    }

    @Override
    protected boolean preCheck() {
        System.out.println("外调21151交易的前置校验");
        return false;
    }

    @Override
    protected boolean feinFinancial() {
        System.out.println("外调21151交易的金融交易");
        return false;
    }

    @Override
    protected boolean feinCSPJ() {
        System.out.println("外调21151交易的主机交易");
        return false;
    }

    @Override
    protected boolean sendMSG() {
        System.out.println("21151交易的报送消息");
        return false;
    }

    public void excutorTrander(){
        super.excutorTrander();
        System.out.println("执行21151交易完成");
    }
}
