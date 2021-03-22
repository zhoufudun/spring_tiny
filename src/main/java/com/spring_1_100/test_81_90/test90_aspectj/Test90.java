package com.spring_1_100.test_81_90.test90_aspectj;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test90 {


    @Test
    public void test1() {
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标对象
        factory.setTarget(waiter);
        // 添加切面类
        factory.addAspect(PreGreetingAspect.class);
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serviceTo("John");
    }

    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring90_aspectj/spring90_aspectj.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("8ds98");
    }

    /**
     * 首先，在配置文件中引入aop命名空间，如 然后通过aop命名空间的<aop:aspectj-autoproxy/> 自动为Spring容器中那些匹配的AspectJ 切面
     * 的Bean创建代理，完成切面织入，当然，Spring 在内部依旧采用AnnotationAwareAspectJAutoProxyCreator进行自动代理的创建工作。
     * 但具体实现张东荪己经被<aop:aspectj-autoproxy /> 隐藏起来。
     * <aop:aspectj-autoproxy/> 有一个proxy-target-class属性，默认为false，表示使用JDK动态代理织入增强，当配置<aop:aspectj-autoproxy proxy-target-class="true"/>
     * 时，表示使用CGlib动态代理织入增强，不过即使使用prxoy-target-class设置为false,如果目标类没有声明接口，Spring 将自动使用CGLib
     * 动态代理技术。
     * 方法切点函数，通过描述目标类方法信息定义连接点。
     * execution()  方法匹配模式串  表示满足某一匹配模式的所有目标类方法连接点。如execution(* greetTo(..))表示所有目标类中的greetTo()方法
     * @annotation() 方法注解类名   表示标了特定注解的目标方法连接点，如@annotation(com.baobaotao.anno.NeedTest)表示任何标注了@NeedTest注解的目标类方法
     * 方法入参切点函数：通过描述目标类方法入参的信息定义连接点。
     * args()        类名     通过判别目标类方法运行时入参对象的类型定义指定连接点，如args(com.baobaotao.Waiter)表示所有的有且仅有
     * 一个按类型匹配于Waiter入参的方法
     * @args()       类型注解类名     通过判别目标方法运行时入参对象的类型是否标特定的注解来指定连接点，如@args(com.baobaotao.Monitorable)表示任何
     * 这样的一个有目标方法，它有一个入参且对象的类标@Monitorable注解
     * 目标类切点函数：通过描述目标类类型信息定义连接点。
     * within()         类名匹配串，表示特定域下的所有的连接点，如within(com.baobaotao.service.*)表示com.baobaotao.service
     * 包中的所有的连接点，即包中所有的类的所有的方法，而within(com.baobaotao.servcie.*Service)表示在com.baobaotao.service包中的
     * 所有的Service结尾的类的所有的连接点。
     * target()         类名  假如目标类按照类型匹配于指定的类，则目标类的所有的连接点匹配这个切点，如通过target(com.baobaotao.Waiter)
     * 定义的切点Waiter，以及Waiter实现类NaiveWaiter中所有的连接点都匹配该切点 。
     * @within()        类型注解类名  假如目标类按类型匹配于某个类A,且类A标了特定的注解，则目标类的所有的连接点匹配这个切点 。
     * 如@within(com.baobaotao.Monitorable)定义的切点，假如Waiter类标了@Monitorable注解，则Waiter以及Waiter实现类的NaiveWaiter
     * 类所有的连接点都匹配。
     * 代理类p切点函数：通过描述目标类代理的信息定义连接点。
     * 目标类切点函数： @target()       类型注解类名 目标类标注了特定注解，则目标类所有的连接点匹配该切点，如@target(com.baobaotao.Monitorable)
     * 假如NaiveWaiter标注了@Monitorable，则NaiveWaiter所有的连接点匹配成功。
     * 代理类切点函数：this()   类名 代理类按类型匹配于指定类，则被代理的目标类所有的连接点匹配成切点，这个函数比较难以理解，这里暂不举例
     * 给后面详解 。
     * @AspectJ还有call() ，initialization() ，preinitialization() staticinitialization() get(),set() ,handler() adviceexecution()
     * withincode() ,cflow() ,cflowbelow(),if() ,@this() 以及@withincode() 函数，这些函数在Spring 中不能使用，
     * IllegalArgumentException() 异常，在不特别声明的情况下，本书所有的@AspectJ函数均所列出的函数 。
     *
     * 有些函数的入参可以接受通配符，@AspectJ支持3种通配符
     * * 匹配任意字符，但是它只能匹配上下文中的一个元素， 。
     * .. 匹配任意字符，可以匹配上下文中的多个元素，但是表示类时，必需和*联合使用，而表示入参时则可以单独使用。
     * + 表示按类型匹配指定类的所有的类，必需跟在类名后面，如com.baobaotao.Car+ 继承或者扩展指定的所有的类，同时还包括指定类的本身。
     * @AspectJ 函数按其是否支持通配符及支持的
     *
     *
     *
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring90_aspectj/spring90_aspectj_autoproxy.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("quyixiao");
    }
}
