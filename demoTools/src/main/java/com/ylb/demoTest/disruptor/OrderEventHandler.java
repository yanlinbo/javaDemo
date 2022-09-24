package com.ylb.demoTest.disruptor;

import com.lmax.disruptor.EventHandler;

public class OrderEventHandler implements EventHandler<OrderEvent> {
    @Override
    public void onEvent(OrderEvent event, long l, boolean b) throws Exception {

        System.out.println("消费者获取数据value:"+ event.getValue()+",name:"+event.getName());
    }
}
