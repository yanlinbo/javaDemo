package com.ylb.demoTest.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class DisruptorDemo {

    /**
     * 单生产者和单消费者
     * @param args
     */
    public static void main0(String[] args) {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                //单生产者
                new YieldingWaitStrategy() //等待策略
        );

        //设置消费者用于处理RingBuffer的事件
        disruptor.handleEventsWith(new OrderEventHandler("0"));
        disruptor.start();
        //创建ringbuffer容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        //创建生产者
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
        //发送消息
        for(int i=0;i<3;i++){
            eventProducer.onData(i,"Fox"+i);
        }
        disruptor.shutdown();
    }


    /**
     * 单生产者多消费者，多消费者间形成依赖关系，每个依赖节点只有一个消费者
     * @param args
     */
    public static void main1(String[] args) {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                //单生产者
                new YieldingWaitStrategy() //等待策略
        );

        //设置消费者用于处理RingBuffer的事件   handleEventsWith 一个消息会被所有消费者消费
        disruptor.handleEventsWith(new OrderEventHandler("0"))
                .then(new OrderEventHandler("1"))
                .then(new OrderEventHandler("2"));
        disruptor.start();
        //创建ringbuffer容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        //创建生产者
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
        //发送消息
        for(int i=0;i<3;i++){
            eventProducer.onData(i,"Fox"+i);
        }
        disruptor.shutdown();
    }

    /**
     * 单生产者多消费者，多消费者。多消费者对于消息不重复消费
     * @param args
     */
    public static void main3(String[] args) {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                //单生产者
                new YieldingWaitStrategy() //等待策略
        );

        //设置消费者用于处理RingBuffer的事件   handleEventsWith 一个消息会被所有消费者消费
        disruptor.handleEventsWithWorkerPool(new OrderEventHandler("0"),new OrderEventHandler("1"));
//                .then(new OrderEventHandler("1"))
//                .then(new OrderEventHandler("2"));
        disruptor.start();
        //创建ringbuffer容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        //创建生产者
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
        //发送消息
        for(int i=0;i<3;i++){
            eventProducer.onData(i,"Fox"+i);
        }
        disruptor.shutdown();
    }

    /**
     * 单生产者多消费者，多消费者。多消费者对于消息独立消费互不干涉
     * @param args
     */
    public static void main4(String[] args) {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                //单生产者
                new YieldingWaitStrategy() //等待策略
        );

        //设置消费者用于处理RingBuffer的事件   handleEventsWith 一个消息会被所有消费者消费
        disruptor.handleEventsWith(new OrderEventHandler("0"),new OrderEventHandler("1"));
//                .then(new OrderEventHandler("1"))
//                .then(new OrderEventHandler("2"));
        disruptor.start();
        //创建ringbuffer容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        //创建生产者
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
        //发送消息
        for(int i=0;i<3;i++){
            eventProducer.onData(i,"Fox"+i);
        }
        disruptor.shutdown();
    }

    /**
     * 多生产者单消费者模式
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                //单生产者
                new YieldingWaitStrategy() //等待策略
        );

        //设置消费者用于处理RingBuffer的事件   handleEventsWith 一个消息会被所有消费者消费
        disruptor.handleEventsWith(new OrderEventHandler("0"));
//                .then(new OrderEventHandler("1"))
//                .then(new OrderEventHandler("2"));
        disruptor.start();
        //创建ringbuffer容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        //创建生产者
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
        //判断生产者是否已经生产完毕
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        //发送消息
        for(int l=0;l<3;l++){
            Thread thread = new  Thread(){

                public void run(){
                    for (int i = 0; i < 3; i++) {
                        new OrderEventProducer(ringBuffer).onData(i,Thread.currentThread().getName()+"-Fox"+i);
                    }
                    countDownLatch.countDown();
                }
            };
            thread.setName("producer thread " + l);
            thread.start();
//            eventProducer.onData(i,"Fox"+i);
        }
        countDownLatch.await();
        disruptor.shutdown();
    }
}



