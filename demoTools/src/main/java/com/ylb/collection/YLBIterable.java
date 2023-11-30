package com.ylb.collection;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;


/**
 * 结论：
 * 1,一个接口可以有多个默认的实现方法。什么场景下会这样使用？
 * 2，接口上可以定义泛型。什么场景下会这样使用？
 */
public interface YLBIterable<T> {

    //返回一个T类型的迭代器
    Iterator<T> iterator();

//    default void forEach(Consumer<? super T> action) {
//        Objects.requireNonNull(action);
//        for (T t : this) {   //todo 这里的this为什么会报错？
//            action.accept(t);
//        }
//    }


    //使用给定的集合的迭代器进行遍历，并且将集合 size() 作为初始的 size
    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
