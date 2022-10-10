package com.ylb.demoTest.DataStructureAndAlgorithms;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {

    public static void main(String[] args) {
        Queue blockingQueue = new ArrayBlockingQueue(2);
//        addTest(blockingQueue,  5);
//        offerTest(blockingQueue,  5);
//            removeTest();
//        putTest();
        takeTest();
    }

    private static void addTest(Queue blockingQueue, int n){
        for (int i = 0; i <n ; i++) {
            blockingQueue.add(i);
        }
    }

    private static void offerTest(Queue blockingQueue, int n){
        for (int i = 0; i <n ; i++) {
            blockingQueue.offer(i);
        }
    }

    /**
     * remove 方法的作用是删除元素并返回队列的头节点，如果删除的队列是空的， remove 方法就会抛出异常。
     */
    private static void removeTest() {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        blockingQueue.add(1);
        blockingQueue.add(2);
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    /**
     * put 方法的作用是插入元素。如果队列已满就无法继续插入,阻塞插入线程，直至队列空出位置
     */
    private static void putTest(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        try {
            blockingQueue.put(1);
            blockingQueue.put(2);
            blockingQueue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * take 方法的作用是获取并移除队列的头结点。如果执队列里无数据，则阻塞，直到队列里有数据
     */
    private static void takeTest(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void checkNotNull(Object e){
        if(e == null){
            throw new NullPointerException();
        }
    }
}
