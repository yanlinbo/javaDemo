package com.ylb.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.cnblogs.com/tuyang1129/p/12683373.html参考
 * @param <T>
 */
public class YLBArrayBlockingQueue<T> extends YLBAbstractQueue<T>
        implements YLBBlockingQueue<T>, java.io.Serializable {

    final Object[] items;
    //todo 源码中没有
    public YLBArrayBlockingQueue(Object[] items, Condition notEmpty, Condition notFull, ReentrantLock lock) {
        this.items = items;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
        this.lock = lock;
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

    int takeIndex;
    private final Condition notFull;
    private T dequeue() {
        // assert lock.getHoldCount() == 1;
        // assert items[takeIndex] != null;
        final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        T x = (T) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        //todo itrs是什么东西？
//        if (itrs != null)
//            itrs.elementDequeued();
        notFull.signal();
        return x;

    }

    final ReentrantLock lock;
    public YLBArrayBlockingQueue(int capacity){
        this(capacity,false);
    }
    public YLBArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }

    @Override
    public void put(T e) throws InterruptedException {
        // 判断元素是否为null，若为null将抛出异常
        checkNotNull(e);
        // 获取锁对象lock
        final ReentrantLock lock = this.lock;
        // 调用lock的lockInterruptibly方法加锁，lockInterruptibly可以响应中断,因为有当前方法有阻塞 notFull.await();
        // 加锁是为了防止多个线程同时操作队列，造成线程安全问题
        lock.lockInterruptibly();
        try {
            // 如果当前队列中的元素的个数为数组长度，表示队列满了，
            // 这时调用notFull.await()让当前线程阻塞，也就是让生产者阻塞
            // 而此处使用while循环而不是if，是考虑到线程被唤醒后，队列可能还是满的
            // 所以线程被唤醒后，需要再次判断，若依旧是满的，则再次阻塞
            while (count == items.length)
                notFull.await();

            // 调用enqueue方法将元素加入数组中
            enqueue(e);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    @Override
    public boolean offer(T e, long timeout, TimeUnit unit) throws InterruptedException {
        // 判断元素是否为null
        checkNotNull(e);
        // 获取线程需要阻塞的时间的纳秒值
        long nanos = unit.toNanos(timeout);
        // 获取锁对象
        final ReentrantLock lock = this.lock;
        // 加锁，并且lockInterruptibly方法会响应中断
        lock.lockInterruptibly();
        try {
            // 若当前队列中元素已满
            while (count == items.length) {
                // 若等待的剩余时间小于0，表示超过了等待时间，则直接返回
                if (nanos <= 0)
                    return false;
                // 让当前线程等待指定的时间，使用notFull对象让线程等待一段时间
                // 方法会返回剩余的需要等待的时间
                nanos = notFull.awaitNanos(nanos);
            }
            // 调用enqueue方法将元素添加到数组中
            enqueue(e);
            // 返回true表示添加成功
            return true;
        } finally {
            // 解锁
            lock.unlock();
        }
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
    public boolean offer(T e) {
        // 判断加入的元素是否为null，若为null将抛出异常
        checkNotNull(e);
        // 获取锁对象
        final ReentrantLock lock = this.lock;
        // 加锁防止线程安全问题，注意这里调用的是lock()方法，这个方法并不响应中断
        // todo 而之前的put方法会响应中断，以为put会阻塞，为了防止它长期阻塞，所以需要响应中断
        // 但是这个方法并不会被阻塞，所以不需要响应中断
        lock.lock();
        try {
            // 若当前队列已满，则不进行添加，直接返回false，表示添加失败
            if (count == items.length)
                return false;
            else {
                // 若队列不满，则直接调用enqueue方法添加元素，并返回true
                enqueue(e);
                return true;
            }
        } finally {
            // 解锁
            lock.unlock();
        }
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
