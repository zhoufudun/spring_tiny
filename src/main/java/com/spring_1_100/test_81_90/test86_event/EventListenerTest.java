package com.spring_1_100.test_81_90.test86_event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventListenerTest {

    /**
     * 因此它拥有一套完善事件发布和监听机制，我们知道java 通过java.util.EventObject 类和java.util.EventListener接口描述事件和
     * 监听器，某个组件或顶架 要建立自己的事件发布和监听机制，一般都通过它们进行定义，在事件体系中，除了事件和监听器以外。还有另外三个
     * 重要概念：
     * 事件源，事件的产生者，任何一个EventObject都必需拥有一个事件源
     * 事件监听器注册表，组件 或者框架的事件监听器不可以飘在水里悬在容器，而必需有所依存，也就是说组件或者框架必需提供一个地方保存事件
     * 监听器，这便是事件监听器注册表，一个事件监听器注册到组件或者框架，其实就是保存在监听器注册表里，当组件和框架中的事件源产生事件时
     * 就会将事件通知这些位于注册表中的监听器。
     * 事件广播器： 它是事件和事件监听器沟通的桥梁，负责把事件通知给事件监听器。
     * 在分析了事件体系后，我们会发现事件体系其实是一种观察者模式的和种具体的实现方式，它并没有任何神秘之处，之所以组件或框架的事件会让一
     * 些开发者觉得神奇，就是因为组件或框架通过观察者模式很好的封装了事件模型并透明的提供给了使用者，使用者只需要按其设定的方式定义
     * 并注册事件监听器，事件体系就可以正常的工作，因此，我们很少的会去关注它的内部实现机理。
     *
     *
     * ApplicationEvent 的唯构造函数ApplicationEvent(Object source) 通过source指定事件源，它们两个子类分别是
     * ApplicationContextEvent ：容器事件，拥有4个子类分别表示容器启动，刷新，停止及关闭的事件。
     * RequestHandleEvent: 这是一个也Web应用相关的事件，当一个HTTP 请求被处理后，产生的该事件，只有在web.xml中定义了DispatcherServlet
     * 时才会产生该事件拥有两个子类，分别代表Servlet及Portlet请求事件。
     * 我们也可以根据需要扩展ApplicationEvent 定义自己的事件，完成其他的特殊的功能。
     *
     *
     * ApplicationListener 接口只定义了一个方法：onApplicationEvent(E event) ,该方法接受ApplicationEvent 事件对象，在该方法中
     * 编写事件响应处理逻辑，而SmartApplicationListener 接口是Spring3.0 新增的，它定义了两个方法：
     * boolean supportEventType(Class<? extends Application> eventType) : 指定监听器支持哪种类型的容器事件，即它会对该类型的事件
     * 做出响应。
     * boolean supportSourceType(Class<?> sourceType) : 该方法指定监听器仅对体积事件源对象作出响应。
     * 连接点由两个信息确定，第一是用方法表示程序执行点。第二是用相对点表示的方位，如在Test.foo()方法执行前连接点，执行点为Test.foo()
     * 方位为该方法执行前的位置，Spring 使用切点对执行点进行定位。而方位则在增强类型中定义。
     * 切点：
     * 每个程序类都拥有多个连接点，如一个拥有两个方法的类，这两个方法都是连接点，即连接点是程序类中客观存在的事件，但是这为数人多的连接中
     * 如何定位到某个感兴趣的连接点呢？AOP 通过切点定位特定的连接点，通过数据库查询的概念来理解切点和连接点的关系再适合不过了。连接点
     * 相当于数据库中的记录，而切点相当于查询条件，切点和连接点不是一对一的关系，一个切点可以匹配多个连接点。
     * 在Spring 中，切点通过org.springframework.aop.Pointcut接口进行描述，它使用类和方法作为连接点的查询条件，Spring Aop 的规则
     * 解析引擎负责解析切点所设定的查询条件，找到对应的连接点，其实确切的说，应该是执行点而非连接点，因为连接点是方法执行前，执行后等包括
     * 方位信息的具体程序执行点，而切点只定位到某个方法上，所以如果希望定位到具体的连接点上，还需要提供方位信息。
     * 增强除了用于描述一段程序代码外，还拥有另一个和连接点相关的信息，这便是执行点的方位。结合执行方位信息和切点信息，我们就可以找到特定的
     * 连接点了。
     * 正是因为拉绳既包含了用于添加到目标连接点上的一段执行逻辑，又包含了用于定位连接点的方位信息，所以，Spring提供了增强接口都是带方位名的
     * BeforeAdvice ,AfterReturningAdvice ,ThrowsAdvice 等，BeforeAdvice 表示方法调用前的位置，而AfterReturningAdvice 表示访问
     * 返回后的位置，所以只有结合切点和增强两者一起上阵才能确定特定的连接点并实施增强逻辑。
     * 增强逻辑的织入目标类，如果没有AOP ，目标业务类需要自己实现所有的逻辑，就如中ForumService所示，在Aop 的帮助下，ForumService
     * 只实现那些非横切逻辑的程序逻辑，而性能监视和事务管理等这些横切逻辑则可以使用AOP 动态织入到特定的连接点上。
     * 引介是一种特殊的增强，它为类添加一些属性和方法，这样，即使一个业务类原本没有实现某个接口，通过AOP 的引介功能，我们可以动态的为该
     * 业务类添加接口的实现逻辑，让业务类成为这个接口的实现类。
     * 织入：
     * 织入是将增强添加对目标类具体的连接点上的过程，AOP 像一台织布机，将目标类，增强或者引介通过AOP这台织布机天衣无缝的编织在一起。
     * 1)编译期织入 ，这要求使用特殊的Java编译器
     * 2)类装载期织入 ，这要求使用特殊的类装载器。
     * 3)动态代理织入，在运行期为目标类添加增强生成子类的方式。
     *  Spring采用动态代理织入，而AspectJ 采用编译期织入和类装载期织入 。
     *  代理
     *  一个类被AOP织入增强后，就产生了一个结果类，它是融合了原类和增强逻辑的代理类，根据不同的代理方式，代理类可能是和原类具有相同的接口的
     *  类，也可能就是原类的子类，所以我们采用调用原类相同的方式调用代理类。
     *  切面
     *  切面由切点和增强引介组成，它既包括了横切逻辑的定义，也包括了连接点定义，Spring AOP 就是负责实施切面的框架，它将切面所定义的横切
     *  逻辑织入到切面所指定的连接点中。
     *  AOP的工作重心在于如何将增强应用于目标对象的连接点上，这里首先包括两个工作：第一，如何通过切点和增强定位到连接点上。第二，如何在
     *  增强中编写切面的代码。
     *
     *  我们通过CglibProxy实现了性能监视横切逻辑的动态织入，但是这种实现方式存在三个明显需要改进的地方。
     *  1) 目标类所有的方法都添加了性能监视横切逻辑，而有时，这并不是我们所期望的，我们可能只希望对业务类中的某些特定的方法添加横切逻辑。
     *  2) 我们通过硬编码的方式指定了织入横切逻辑的织入点，即在目标类业务方法的开始和结束前织入代码。
     *  3) 我们手工编写代理实例创建过程，为 不同的类创建代理时，需要分别编写相应的创建代码，无法通用。
     *  CGLib 所创建的动态代理对象的性能依旧比JDK所创建的代理对象的性能高不少（10倍），但是CGLib在创建代理对象时所花费的时候却比JDK
     *  动态代理多（8倍），所以对于singleton和代理对象或者具有实例池的代理，因为无须频繁创建代理对象，所以比较适合CGLib动态代理 技术。
     *  反之适合用JDK动态代理技术，值得一提的是，由于CGLIb采用的是创建子类的方式生成代理对象，所以不能对目标类中的final方法进行代理 。
     *  前置增强：org.springframework.aop.BeforeAdvice 代表前置增强，因为Spring只支持方法级别的增强，所以MethodBeforeAdvice
     *  是目前可用的前置增强，表示在目标方法执行前实施增强，而BeforeAdvice 是为了将来版本扩展需要而定义的。
     *  后置增强：org.springframework.aop.AfterReturningAdvice 代表后增强，表示在目标方法执行后实施增强。
     *  环绕增强：org.aopalliance.intercept.MethodInterceptor代表环绕增强，表示在目标方法执行前后实施增强。
     *  异常抛出增强：org.springframework.aop.ThrowsAdvice代表抛出异常增强。表示在目标方法抛出异常后实施增强。
     *  引介增强：org.springframework.aop.IntroductionInterceptor 代表引介增强，表示是目标类添加一些新的方法和属性。
     *  这些增强接口都有一些方法，通过实现这些接口方法，在接口方法中定义横切逻辑就可以将它们织入到目标方法的相应连接点位置。
     *
     *
     *
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring86_event.xml");
        MailSender mailSender = ctx.getBean(MailSender.class);
        mailSender.sendMail("aaa@bbb.com");
    }
}
