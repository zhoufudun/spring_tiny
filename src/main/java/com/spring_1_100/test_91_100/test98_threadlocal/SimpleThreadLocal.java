package com.spring_1_100.test_91_100.test98_threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * TheadLocal和线程同步机制相比有什么优势呢？ThreadLocal和线程同步机制都是为了了解多线程中相同变量的访问冲突问题
 * 在同步机制中，通过对象的锁定机制保证同一时间只有一个线程访问变量，这时该变量是多个线程共享的，使用同步机制要求程序缜密的分析什么时候对变量进行
 * 读写，什么时候需要锁定某个对象，什么时候释放对象锁等繁杂问题，程序设计和编写难度相对较大
 *
 * 而ThreadLocal则从另一个角度来解决多线程并发访问问题，ThreadLocal为每一个变量提供了一个变量副本，从而隔离了多个线程对访问的数据的冲突
 * 因为每个线程都拥有自己的副本，从而也就没有必要对该变量进行同步了，ThreadLocal提供了线程安全的对象封装，在编写多线程代码时，可以把
 * 不安全的变量封装进行ThreadLocal的使用
 * 由于ThreadLocal中可以持有任何类型的对象，低版本的JDK 由于ThreadLocal中可以持有任何类型的变量，低版本JDK所提供的get()返回
 * 访问串行化，对象共享化，而ThreadLocal采用了以空间换取时间的方式，访问并行化，对象独享化，前者提供了一份变量，让不同的线程排队访问，
 * 而后者每一个线程都提供了一份变量，因此，可以同时访问而互不影响。
 *
 * 我们知道在一般情况下，只有无状态的Bean才可以在多线程环境下共享，在Spring中绝大部分的Bean都可以声明为singleton作用域，
 * 就因为Spring对一些Bean如RequestContextHolder ,TransactionSynchronizationManager ，LocaleContextHolder 等，中非线程安全
 * 的状态性对象，采用了ThreadLocal进行封装，让它们也成为了线程安全的，状态性对象，因此有了状态的Bean 就能够为singleton的方式在多线程中
 * 正常工作了。
 * 一役的Web应用划分为展现层，服务层和持久层三个层次，在不同的层中编写对应的逻辑，下层通过接口向上层开放功能调用，从接收请求到返回响应
 * 所经过的所以程序调用都属于一个线程，如图9-2 所示
 * 这样用户就可以根据需要，将一些非线程安全的变量以ThreadLocal存放，在同一次请求响应的调用线程中，所有的对象所访问的同一ThreadLocal变量
 * 都是当前线程所绑定的，下面实例能够体现Spring对状态Bean的改造思路
 *
 * 由于Spring 事务管理是基于接口代理或者动态字节码技术，通过AOP实施事务增强的，虽然Spring支持
 * ASpectJ LTW 在类加载期实施增强，但这种方法很少使用，所以我们不予关心。
 *
 * 但是由于集成第三方的产品，整合遗产代码等原因，可能需要直接数据源或者直接获取数据连接及其衍生器，这时如果使用不当，就可能在无意中创建
 * 出一个魔鬼般的事务连接泄漏问题。
 * 它首先查看当前是否存在事务管理上下文，并尝试从事务管理上下文中获取连接，如果获取失败，直接从数据库获取连接，在获取连接后，如果当前拥有
 * 事务上下文，则将连接绑定到事务上下文中。
 * 对数据源进行代理后，我们就可以通过数据源代理对象的getConnection()获取事务上下文 绑定的数据库连接，因此，如果数据源己经进行了TransactionAwareDataSourceProxy
 *
 * 1)定义子类，在子类中声明SQL语句并执行数据查询操作。
 * 2)声明子类的变量并实例化该类
 * 3)使用MappingSqlQuery 的方法执行数据查询操作。
 *
 *
 */
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap());

    public void set(Object newValue) {
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        //返回本地线程的变量
        Object o = valueMap.get(currentThread);
        // 如果Map在Map 不存在，放到Map中保存起来
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initValue() {
        return null;
    }


}
