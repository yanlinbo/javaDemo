package com.ylb.collection;

import java.util.Collection;

public interface YLBQueue<T> extends Collection<T> {

    //在父类中已经定义过了，这里为什么还要在定义一遍？岂不是多此一举？
    boolean add(T t);

    //add 和 offer 有何区别？如何实现offer?
    boolean offer(T t);

    T remove();

    T poll();

    T element();

    T peek();
}
