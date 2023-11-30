package com.ylb.collection;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public interface YLBBlockingQueue<T> extends Queue<T> {

    boolean add(T e);

    boolean offer(T e);

    void put(T e) throws InterruptedException;

    boolean offer(T e, long timeout, TimeUnit unit)
            throws InterruptedException;

    T take() throws InterruptedException;

    T poll(long timeout, TimeUnit unit)
            throws InterruptedException;

    int remainingCapacity();
    
    boolean remove(Object o);

    public boolean contains(Object o);

    int drainTo(Collection<? super T> c);

    int drainTo(Collection<? super T> c, int maxElements);
}
