package com.ylb.demoTest.designPattern.bridge.actualCombat;

/**
 * 父类抽象
 */
public abstract class BGLtrander {
    /**
     * 构建上下文
     * @return
     */
    protected abstract boolean buildContext();

    /**
     * 对上送项做前置校验
     */
    protected abstract boolean preCheck();

    /**
     * 外调金融交易
     */
    protected abstract boolean feinFinancial();

    /**
     * 外调旧线主机交易
     */
    protected abstract boolean feinCSPJ();

    /**
     * 后置处理：发消息
     */
    protected abstract boolean sendMSG();

    public void excutorTrander(){
        this.buildContext();
        this.preCheck();
        this.feinFinancial();
        this.feinCSPJ();
        this.sendMSG();
    }
}
