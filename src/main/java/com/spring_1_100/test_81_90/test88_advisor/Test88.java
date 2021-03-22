package com.spring_1_100.test_81_90.test88_advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test88 {


    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring88_advisor.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greetTo("quyixiao");
        waiter.serviceTo("xiaoming");
        seller.greetTo("xiaohu");


    }

    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring88_advisor.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter1");

        waiter.greetTo("quyixiao");
        waiter.serviceTo("xiaoming");


    }

    /**
     * GreetingDynamicPointcut 类既有静态切点检查的方法，也有用于动态切点检查的方法，由于动态切点检查会对性能造成很大的影响，我们应当
     * 尽量避免在运行时每次都对目标类的和个方法进行动态检查，Spring 采用这样的机制，在创建代理时对目标类的每个连接点使用静态静态切点检查。
     * 如果仅通过静态切点检查就可以知道连接点是不匹配的，则在运行时就不再进行动态检查了，如果静态切点检查是匹配的，在运行时才进行动态切点检查
     * 通过以上的输出信息，对照DynamicMethodMatcherPointcut切点
     *
     * 在动态切点类定义静态切点检查的方式可以防止不必要的动态检查操作，因此极大的提高了运行效率，这一点我们在稍后运行测试中再进一步的分析。
     * 我们介绍了动态代理的概念，在这里，我们又碰到了动态切面的概念，这两个概念很容易让人混淆，其实动态代理是动态的是相对于那些编译期
     * 生成代理为类加载期生成代理而言的，动态代理是运行时动态产生的代理，在Spring中，不管是静态切面还是动态切面都是通过动态代理技术实现
     * 的，所谓静态切面是指在生成代理对象时，就确定了增强是否需要织入到目标类连接点上，而动态切面是指必须在运行期根据方法入参值来判断增强
     * 是否需要织入到目标类连接点上。
     *
     *
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring88_advisor.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        waiter.greetTo("Tom");
        waiter.serviceTo("xiaoming");
    }


    /**
     * 流程切面和动态切面从某种程度上说可以算是一类切面，因为两者都需要在运行期判断动态的环境，对于流程切面来说，代理对象在每次调用目标类方法
     * 时，都需要判断方法调用堆栈中是否满足流程切面的要求，因此，和动态切面一样，流程切面对性能影响也很大，
     * 在JVM1.4上，流程切点通常比其他的要慢5倍以上，在JVM1.3要慢10倍以了
     *
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring88_advisor.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);

        waiter.greetTo("Peter");
        waiter.serviceTo("Peter");


        wd.service("Peter");
    }

    /**
     * 当然手记也是可以只通过一个切点描述同时满足以上两个匹配条件连接点。而更好的方法是使用Spring为我们提供的ComposablePointcut
     * 把两个切点组合起来，通过切点的复合运算表示，ComposablePointcut可以将多个切点以并集或者交集的方式组合起来，提供了切点之间的复合运算
     * ComposablePointcut 本身也是一个切点，它实现了Pointcut接口，下面先来了解一下ComposablePointcut的构造函数 。
     * ComposablePointcut() ：构造一个匹配所有类的所有的方法的复合切点。
     * ComposablePointcut(ClassFilter classFilter) : 构造一个匹配所有类的特定方法复合切点 ；
     * ComposablePointcut(ClassFilter classFilter,MethodMatcher methodMatcher) : 构造一个匹配特定的方法的复合切点 。
     * ComposablePointcut提供三个交集运算方法：
     * ComposablePointcut intersection(ClassFilter filter) :将复合切点和一个ClassFilter对象进行次运算，得到一个结果复合切点 。
     * ComposablePointcut intersection(MethodMatcher mm); 将一个复合切点和一个MethodMatcher对象进行交集运算，得到一个结果复合切点 。
     * ComposablePointcut intersection(Pointcut other) : 将复合切点和一个切点对象进行交集运算，得到一个结果复合切点 。
     * ComposablePointcut 提供了两个并集运算的方法：
     * ComposablePointcut union(ClassFilter filter) :
     *
     *
     * DefaultIntroductionAdvisor拥有三个构造函数：
     * DefaultIntroductionAdvisor（Advice advise）通过一个增强创建的引介切面，引介切面将和一个指定的接口拉绳对象中所有的接口的实现。
     * DefaultIntroductionAdvisor(DynamicIntroductionAdvice advise,Class clazz) : 通过一个增强和一个指定的接口类创建引介切面。
     * 仅为目标对象新增的clazz接口的实现。
     * DefaultInroductionAdvisor(Advisor advice,IntroductionInfo inroductionInfo): 通过一个增强和一个IntroductionInfo 创建一个
     * 切面，目标对象需要实现哪些接口，由IntroductionInfo 对象的getInterfaces()表示。
     *
     *
     *
     */
    @Test
    public void test5(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring88_advisor.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter4");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);

        waiter.greetTo("Peter");
        waiter.serviceTo("Peter");

        System.out.println("=========================================================");
        wd.service("Peter");
    }


    /**
     * 基于Bean的配置名规则自动代理创建器，允许为一组特定的配置名的Bean自动创建代理实例的代理创建器，实现类为BeanNameAutoProxyCreator
     * 基于Advisor匹配机制的自动代理创建器，它会对容器中的所有的advisor进行扫描，自动将这些切面应用到匹配的bean中，即为目标Bean创建代理实例。
     * 基于Bean的AspectJ注解标签自动代理创建器，为包含AspejctJ注解的Bean自动创建代理实例，它的实现类是AnnotationAwareAspectAutoProxyCreator
     * 该类是Spring 2.0 新增的类。
     * 从上图中，我们可以清楚的看到所有的自动代理创建类都实现了BeanPostProcessor 在容器实例化Bean时，BeanPostProcessor将对它进行加工处理
     * ，所以，自动代理创建器有机会对满足匹配规则的Bean自动创建代理对象。
     * 在本章中，我们暂时不涉及AspectJ 的内容，所以下面，我们只讲解BeanNameAutoProxyCreator和DefaultAdvisorAutoProxyCreator的用法
     *
     *
     *
     */
    @Test
    public void test6(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring88_advisor.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("TOM");
    }
}
