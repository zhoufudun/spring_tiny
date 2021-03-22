package com.spring_1_100.test_31_40.test31_singleton_prototype_lazy_init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test31 {


    public static void main(String[] args) {
        /**
         * 默认情况下，Spring 的 ApplicationContext 容器在启动时，自动的实例化所有的singleton 的 bean 并缓存在容器中，虽然启动时
         * 会花费一些时间，但是也带来了两个好处：
         * 1.首先对 Bean 提前实例化操作会及早发现一些潜在的配置问题，其次 bean 以缓存的方式保存，当运行时使用该 bean 时就无须再实例化了
         * ,加快了运行的效率，
         * lazy-init="true" 的 bean在某些情况下依旧会提前实例化，如果该 bean 被其他的需要提前实例化的 bean  引用到了，Spring 也将忽略
         * 延迟实例化的设置
         *
         * 默认情况下，Spring 容器在启动时不实例化 prototype 的 bean ，此外，Spring 容器将 prototype 的 bean 交给调用者后，就不再
         * 管理它的生命周期了
         *
         * 探究 Spring 第一，考虑版本兼容问题，毕竟针对 Web 应用的 Bean 作用域在 Spring 2.0 开始提供，第二，这三种新增的 Bean 的作用
         * 域使用场合并不多，往往用户并不是真的需要这些新增的 Bean 的作用域
         *
         * request 作用域
         * 顾名思义，request 作用域的 bean 对应一个 HTTP 请求和生命周期，考虑下面的配置：
         * <bean name="car" class="com.baobaotao.scope.Car" scope="request"></bean>
         * 这样，每次 HTTP 请求调用到 car Bean 时，Spring 容器创建一个新的 car  Bean ，请求处理完毕后，销毁这个 Bean
         * session 作用域
         * 假设将以上的 Car 作用域调整为 session 类型：
         * <bean name="car" class="com.baobaotao.scope.car" scope="session"></bean>
         * 这样配置后，car Bean 的作用域横跨整个 HTTP Session ，Session 中所有的 HTTP 请求都共享一个 car Bean ，当 HTTP Session
         * 结束后，实例才被销毁
         *
         * GlobalSession 作用域
         * 下面配置片断将 Car 作用域设置为 globalSession
         *  <bean name="loginController" class="com.baobaotao.scope.car" scope="globalSession"></bean>
         * globalSession 作用域类似于 session 作用域，不过仅在 Portlet 的 Web 应用中使用，Portlet 规范定义了全局 session 的概念
         *  它被组成 portlet Web  应用所有的子 Portlet 共享，如果不在 Portlet Web 应用环境下，globalSession  自然就等价于 session
         *  的作用域了
         *
         *
         * 细心的朋友可能有一个疑问，在第三章节介绍webApplicationContext 初始化时，我们己经通过 ContextLoaderListener 或者
         * ContextLoaderServlet 将 web 容器与  Spring 容器整合，为什么在这里又要引入一个额外的 RequestContextListener 以支持
         * Bean 的另外的3个作用域呢？通过分析两个监听器的源码，一切疑问都真相大白了，
         * 该监听器 HTTP 请求事件，Web 遥、服务器接收的第一次请求都会通知该监听器
         * Spring 容器启动和凌凌操作都由 Web 容器的启动和关闭事件触发，但如果 Spring 容器中的 Bean 的需要request ,session 和
         * globalSession 作用域的支持，Spring 容器本身就必需获得 Web 容器的 Http 请求事件，驱动 Bean 作用域的控制逻辑，也就是说
         * 通过配置 RequestContextListener ，Spring 容器和 Web 容器的结合更加官媒了，也就是说，通过配置 RquestContextListener ,
         * Spring  容器和 Web 容器的结合更加密切了，Spring 容器能够对 web 容器中的风吹草动若观火便实施 Web 相应的 bean 的作用域的
         * 控制
         * 当然，Spring 完全可以提供一个既实现了 ServletContextListener ，又实现了 ServletContextListener 接口的监听器，这样我们
         * 仅需要考虑，第一，考虑版本的兼容问题，毕竟针对 Web 应用的 Bean  的作用域是在 Spring 2.0 开始提供的，第二，第三种新增的
         * Bean 的作用域的使用场合并不多，往往用户并不是真的需要这些新增的 Bean 作用域
         *
         *
         * request 作用域
         * 顾名思义，request 作用域的 bean 对应一个 HTTP  请求生命周期，考虑下面的配置
         * <bean name="car" class="com.baobaotao.scope.Car" scope="request"></bean>
         * 这样，每次 HTTP 请求调用的 Car Bean 时，Spring 容器创建一个新的 car Bean ，请求处理完毕以后，销毁这个 Bean
         * session 作用域
         * 假设将以上的 Car 的作用域调整为 Session 类型：
         * <bean name="car" class="com.baobaotao.scope.Car" scope="session"></bean>
         * 这样的配置后，car Bean 的作用域横跨整个 HTTP Session ,Session 中所有的 HTTP 请求都共享同一个 car Bean ，当 HTTP Session
         * 结束后，实例才被销毁
         * globalSession 作用域
         * 下面的配置片断将 car 的作用域设置为 globalSession
         * 4. 作用域依赖问题
         * <bean name="car" class="com.baobaotao.scope.Car" scope="request">
         *     <aop:scope-proxy></aop>
         * </bean>
         * <bean id="boss" class="com.baobaotao.scope.Boss">
         *     <property name="car" ref="car"></property>
         * </bean>
         * 在代码清单中，car Bean 是 request 作用域，它被 singleton 作用域的 bossBean 引用，为了 boss 能够从适当的作用域中获取car
         * Bean 的引用，  需要使用 Spring Aop 语法为 Car Bean 配置一个代理类，如果2 所示，为了能够在配置文件中使用 AOP 的配置标签
         * 我们需要在文档的声明头中定义 aop 命名空间
         * 当 boss Bean 在 Web 环境下调用 car Bean 时，Spring AOP 将启动动态代理智能地判断 boss Bean 位于哪个 HTTP 请求的线程中
         * ，并从对应的 HTTP 请求线程域中获取对应的 car Bean ，我们通过图4-5 对此进行剖析
         * boss Bean 的作用域是 singleton ，也就是说，在 Spring 容器中始终只有一个实例，而 car Bean 的作用域为 request ，所以每个
         * 调用到 car Bean 的那些 HTTP 请求都会创建一个 car Bean ,Spring 通过动态代理技术，能够让 boss Bean 引用到对应的 Http 请求的
         * car Bean 中
         * 反过来，我们很容易知道配置文件中添加<aop:scoped-proxy/> 后，注入到 boss Bean 中的 car Bean 己经不是原始的 car  Bean 了
         * ,而是 car Bean 的动态代理对象
         * 动态代理所添加的逻辑其实也很简单，即判断当前的 boss位于哪个线程中，然后根据这个线程找到对应的 HttpRequest 域中获取对应的 car
         * ，因为 Web  容器的特性，一个 Http 请求一般情况下对应一个独立的线程
         * Java 语言只能对接口提供自动代理，所以如果需要对类提供的代理，则需要在类路径中加入 CGlib 的类库，这时 Spring 使用 CGlib 为
         * 类生成动态代理的子类，我们将在第6章及第7章中讨论 Spring Aop 的知识
         * 一般情况下，Spring 通过反射机制利用<bean>的 class 属性指定实现类实例化 Bean 的某些情况下，实例化Bean 的过程比较复杂，如果按照
         * 传统的方式，则需要在<bean>中提供大量的配置信息，配置方式的灵活性受限，这时采编码的方式可能会得到一个简单的方案，Spring 为此
         * 提供了一个 org.springframework.beans.factory.FactoryBean  工厂类接口，用户可以通过实现该工厂接口定制实例化 Bean 的逻辑
         * FactoryBean 接口对于 Spring框架来说占用重要的地位，Spring 自身就提供了70多个 FactoryBean 的实现类，它们隐藏了实例化的一些
         * 复杂的 Bean 的实现细节，给上层应用带来了便利，
         * T Spring3.0 开始，FactoryBean 开始支持泛型，即接口声明改为 FactoryBean<T> 的形式，在该接口中共定义了以下3个接口方法
         * T getObject() ： 返回由 FactoryBean  创建的 Bean 的实例，如果 isSingleton() 返回 true ,则该实例会放到 Spring 容器的
         * 单例缓存池中
         * boolean isSingleton() : 确定由 FactoryBean  创建的 Bean 的作用域是 singleton 还是 prototype
         * Class<?> getObjectType()：  返回 FactoryBean  创建 Bean 的类型
         *  当配置文件中<bean>的 class 属性配置的实现类是 FactoryBean 时，通过 getBean() 方法返回的不是 FactoryBean 的本身，而是
         *  FactoryBean#getObject()  方法所返回的对象，相当于 FactoryBean#getObject() 代理了 getBean()方法
         *  在前面的例子中，我们在配置 Car 时，Car 的每个属性分别对应一个<property> 元素标签，假设我们嫌这种方式不够简洁，而希望
         *  通过逗号分隔的方式一次性的为 Car 的所有的属性指定配置的值，那么我们可以通过编写一个 FactoryBean 来达到目的
         *
         *
         *
         *
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring31_singleton_prototype_lazy_init.xml");
        Boss boss11 = (Boss)ac.getBean("boss11");
        Boss boss12 = (Boss)ac.getBean("boss12");
        System.out.println(boss11.getCar() == boss12.getCar());


        Boss boss21 = (Boss)ac.getBean("boss21");
        Boss boss22 = (Boss)ac.getBean("boss22");
        System.out.println(boss21.getCar() == boss22.getCar());

    }
}
