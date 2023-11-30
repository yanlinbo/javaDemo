package com.ylb.collection;


public abstract class YLBAbstractQueue<T> implements YLBQueue<T> {


    /**
     * protected表明该构造方法只能被子类使用
     */
    protected YLBAbstractQueue() {
    }

    /**
     * 1，add 和 offer的作用相同，区别是add会抛异常
     * 2，这里使用了模板方法
     */
    public boolean add(T e) {
        if (offer(e))
            return true;
        else
            throw new IllegalStateException("Queue full");
    }
}
