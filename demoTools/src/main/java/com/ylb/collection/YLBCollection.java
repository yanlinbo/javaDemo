package com.ylb.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 * 1,接口和接口之间是继承的关系，接口·和类之间是实现的关系，类和类之间是继承的关系
 */
public interface YLBCollection<T> extends YLBIterable<T> {


    //集合总得有元素的个数吧
    int size();

    //没有元素的集合为空集合
    boolean isEmpty();

    //集合中是否包含某个元素
    boolean contains(Object o);

    boolean containsAll(Collection<?> c);

    //迭代器
    Iterator<T> iterator();

    //集合与数组之间如何转化？
    Object[] toArray();

    //todo 这个方法没用过
    <T> T[] toArray(T[] a);

    //向集合中添加元素，是否添加成功
    boolean add(T e);

    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    //todo remove和clear有何区别？
    void clear();

    //todo 这是什么方法
    boolean retainAll(Collection<?> c);

    //如何实现两个对象相等？
    boolean equals(Object o);

    //如何实现hash
    int hashCode();

    /**
     *
     * 1，该方法表示如果存在就删除
     */
    default boolean removeIf(Predicate<? super T> filter){
        Objects.requireNonNull(filter); //判断过滤条件是否为空，为空抛异常
        boolean removed = false;  //赋初始值为不删除
        final Iterator<T> each = iterator();  //首先获取一个迭代器
        while (each.hasNext()) { //判断是否存在下一个元素
            if (filter.test(each.next())) { //todo
                each.remove();  //删除
                removed = true;  //删除成功
            }
        }
        return removed;
    }
}
