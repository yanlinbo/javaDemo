package com.ylb.demoTest.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * implements EventHandler<Order>, WorkHandler<Order>
 */
public class OrderEventHandler implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {

    /**
     * 增加该构造方法的目的是为了生成多个不同的消费者
     */
    private String consumerId;
    public OrderEventHandler(String consumerId){
        this.consumerId = consumerId;
    }
    @Override
    public void onEvent(OrderEvent event, long l, boolean b) throws Exception {

        System.out.println("OrderEventHandler "+ this.consumerId +",消费者获取数据value:"+ event.getValue()+",name:"+event.getName());
    }

    @Override
    public void onEvent(OrderEvent orderEvent) throws Exception {
        System.out.println("OrderEventHandler "+ this.consumerId +",消费者获取数据value:"+ orderEvent.getValue()+",name:"+orderEvent.getName());
    }
}
