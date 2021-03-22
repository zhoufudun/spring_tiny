package com.spring_1_100.test_81_90.test87_aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class GreetingThrowsAdvice implements ThrowsAdvice {

    // 定义增强逻辑

    /**
     * ThrowsAdvice 异常抛出增强接口没有定义任何方法，它是一个标识接口，在运行期Spring使用反射机制自行判断，我们必需采用以下签名形式定义
     * 异常抛出的增强方法
     * void afterThrowing(Method method, Object[] args, Object target, Exception ex);
     * 方法名必需为afterThrowing，方法入参规定如下：前三个入参Method method,Object [] args,Object target是可选的（要么三个入参提供，要么
     * 不提供），而最后一个入参是Throwable或其子类，如以下的方法是合法的。
     * afterThrowing(SQLException e ) ;
     * afterThrowing(RuntimeException e ) ;
     * afterThrowing(Method method,Object [] args ,Object target ,RuntimeException e ) ;
     * 而以下的方法是非法的。
     * afterThrowing(Object [] args,Object target,RuntimeException e );缺少Method ；
     * solveThrowing(SQLException e ) ;方法名非法。
     * 可以在同一个异常抛出增强中定义多个afterThrowing() ，当目标类方法抛出异常时，Spring会自动选用最匹配的增强方法，假设在增强中定义了
     * 两个方法：
     * afterThrowing(SQLException e );
     * afterThrowing(Throwable e ) ;
     * 当目标方法抛出一个SQLException时，将调用afterThrowing(SQLException e )而非afterThrowing(Throwable e )进行增强，在类的继承
     * 树上，两个类的距离越近，我们就说这两个类相似度就越高，目标方法抛出异常后，优先选取用异常入参和抛出异常相似度最高的afterThrowing()方法
     * 标识接口是没有任何方法和属性的接口，标识接口不对实现类有任何语义上的要求，仅仅表明它的实现类属于一个特定的类型，它非常类似于Web 2.0
     * 中的TAG 的概念。Java 使用它标识某一类对象，主要有两个用途，第一，通过标识接口标识同一类型的类，这些类本身可能并没有具有相同的方法。
     * 如 Advise接口，第二，通过标识接口使程序或JVM 采取一些特殊的处理，如java.io.Serializable，它告诉JVM 对象可以被序列化。
     *
     * Spring 定义了引介增强接口IntroductionInterceptor，该接口没有定义任何的方法，Spring 为该接口提供了DelegatingIntroductionInterceptor
     * 实现类，一般情况下，我们通过扩展该实现类定义自己的引介增强。
     *
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("======抛出异常：" + ex.getMessage());
    }
}
