package com.ylb.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class YLBArrayBlockingQueue<T> extends YLBAbstractQueue<T>
        implements YLBBlockingQueue<T>, java.io.Serializable {

    final Object[] items;
    //todo 源码中没有
    public YLBArrayBlockingQueue(Object[] items, Condition notEmpty) {
        this.items = items;
        this.notEmpty = notEmpty;
    }


    /**
     * todo dec(int i)的结果可能是-1
     */
    final int dec(int i) {
        return ((i == 0) ? items.length : i) - 1;
    }



    final T itemAt(int i) {
        return (T) items[i];
    }

    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    /** put, offer, or add 元素的索引位置 */
    int putIndex;

    /** queue中元素的个数 */
    int count;
    /** Condition for waiting takes */
    private final Condition notEmpty;

    private void enqueue(T x) {
        // assert lock.getHoldCount() == 1;
        // assert items[putIndex] == null;
        final Object[] items = this.items;
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
        notEmpty.signal();  //当队列中元素不为空时唤醒消费者消费
    }

    @Override
    public void put(T e) throws InterruptedException {

    }

    @Override
    public boolean offer(T e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public T take() throws InterruptedException {
        return null;
    }

    @Override
    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super T> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super T> c, int maxElements) {
        return 0;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
