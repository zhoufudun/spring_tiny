package com.spring_1_100.test_91_100.test95_pointcut;

/***
 * 访问连接点信息
 * AspectJ 使用org.aspectj.lang.JoinPoint 接口表示目标类连接点对象，如果环绕增强时，使用org.aspectj.lang.ProceedingJoinPoint
 * 表示连接点对象，该类的joinPoint的子接口，任何一个增强方法都可以通过将第一个入参声明为JoinPoint访问到连接点上下文的信息，我们
 * 先来了解一下这两个接口主要方法。
 * JoinPoint
 * java.lang.Object[] getArgs() : 获取连接点方法运行时参数列表
 * Signature getSignature(): 获取连接点方法签名对象
 * java.lang.Object getTarget() : 获取连接点所有的目标对象
 * java.lang.Object getThis() : 获取代理对象本身。
 * ProceedingJoinPoint
 * ProceedingJoinPoint : 继承JoinPoint子接口，它新增了两个用于执行连接点方法的方法，
 * java.lang.Object proceed() throws java.lang.Throwable : 通过反射执行目标对象的连接点处的方法
 * java.lang.Object proceed(java.lang.Object [] args) throws java.lang.Throwable: 通过反射执行目标对象连接点处的方法，不过使用
 * 新的入参替换原来的入参
 * 我们通过args(name,num,...)进行连接点参数绑定，和前面我们所讲述的方式不同，当args()函数入参为参数名时，共包括两方面的信息。
 * 1)连接点匹配的规则信息，连接点方法第一个入参是String类型，第二个入参是int类型。
 * 2)连接点方法入参和增强方法入参绑定信息：连接点方法的第一个入参绑定到增强方法的name参数上，第二个入参绑定到增强方法的num入参上
 * 切点匹配和参数绑定的过程是这样的，首先args()根据参数名称在增强方法中查到名称相同的入参并获对应的类型，这样就知道匹配连接点方法的入参
 *类型，其次连接点方法入参类型所在的位置则由参数名在args()函数中声明的位置决定，args(name,num)匹配的目标类方法的每一个入参必需是String
 * 类型，第二个入参必需是int类型，如smail(String name,int times)匹配，而smail(int times,String aname)不匹配，我们可能通过
 * 和args()一样，其他可以绑定连接点参数的切点函数如（@args()和target()等），当指定参数名时，就同时具有匹配切点和绑定参数的双重功能。
 * 通过2处查找出waiter对应的类型为Waiter，因而切点表达式为this(Waiter)，当增强方法织入目标连接点时，增强方法通过waiter入参可以引用到
 * 代理对象实例。
 * 1处切点表达式首先按类变量名查找，
 * 7.7.4 绑定连接信息
 * 基于Schema配置的增强谢谢老婆绑定连接点信息和基于@AspectJ绑定连接点信息所使用的方式没有什么区别
 * 第一，所有的增强类型对应的方法第一个入参都可以声明为JoinPoint（环绕增强可声明为ProceedingJoinPoint） 访问连接点信息；
 * 第二，<aop:after-returning>(后置增强)可以通过returning属性绑定连接点方法的返回值<aop:after-throwing> 抛出异常增强，可以
 * 通过throwing属性绑定连接点方法所抛出的异常
 * 第三，所有的增强类型都可以通过可绑定参数的切点函数绑定连接点方法入参，
 * 第一，二种绑定参数访问，我们己经在7.7.3 节中进行了介绍，我们通过一个实例来了解第三种参数绑定方法。
 * 现在我们己经掌握了4种定义切面的方式
 * 1)基于@AspectJ 注解的方式
 * 2)基于<aop:aspect>的方式
 * 3)基于<aop:advisor>的方式
 * 4)基于Advisor 类的方式
 * 作为开发者，我们可能会觉得Spring在同一个问题上提供了了太多的选择，在选择实现方案时反倒让人陷入困境，其实Spring并不是在做一件吃力不讨好
 * 的事情，我们完全可以根据项目的具体的情况做出选择，如果项目采用了JDK 5.0 可以优先考虑使用@AspectJ，如果项目只能使用低版本的JDK ,则可以
 * 考虑使用<aop:aspect>，如果正在升级一个基于低版本的 Spring  AOP 开发项目，则可以考虑使用<aop:advisor> 利用己经存在Advice类，
 * 如果项目只能使用低版本的Spring ,那么就只能使用Advisor了，此外，值得注意的是一些切面只能使用基于API 的Advisor方式进行构建，如基于
 * ControlFlowPointCut流程切面。
 * final 增强，@After <aop:after>  无对应接口，同Advisor
 * 切点定义 支持AspectJ 切点表达式语法，可以通过@Pointcut注解定义命名切点， 支持AspectJ 切点表达式语法，可以通过<aop:Pointcut>定义命名切点
 * 直接通过基于Pointcut的实现类定义切点，基本上和<aop:aspect>相同，不过切点函数不能绑定参数
 * 连接点方法入参绑定， 使用JoinPoint ,ProceedingJoinPoint 连接点对象，使用切点函数我绑定参数名绑定， 同@AspectJ <aop:after-returning>
 * 从表中，我们可以看出<aop:advisor>其实是<aop:aspect> 和Advisor的混血儿，它们切点表示的方式和<aop:aspect>相同，增强定义方式则和Advisor相同
 * 连接点方法入参的绑定方式和Advisor一样，通过增强接口方法中的入参进行调用，所以<aop:advisor>在切点表达式中，需要注意不能使用切点函数绑定连接点
 * 方法入参，否则会产生错误。
 * 在内部，Spring 使用AspectJExpressionPointcut ，为@AspectJ ,<aop:aspect> 以及<aop:advisor>提供具体的切点实现。
 * JVM Class文件字节码转换基础知识
 * 到目前为止，我们所接触到的AOP切面织入都是在运行期通过JDK代理或者CGLIb代理的方式实现的，我们知道，除了运行期织入之外，还可以在类加载期
 * 除了运行期织入切面的方式外，还可以在类加载期通过字节码编辑的技术，将切面织入到目标类中，这种织入方式称为LTW (Load time Weaving)
 * AspectJLTW 使用Java 5.0 所提供的代理功能，（agent） 完成加载期切面织入工作，Java 代理功能让代理访问器访问到JVM 的底层部件，
 * 借此向JVM注册类文件转换器，在类加载时对类文件字节码进行转换，AspectJ LTW 由于基于java 代理技术工作，而Java 代理的作用范围是整个JVM
 * 的，所以这种工作方式比较粗放，对于单一的JVM多个应用的情况尤其不适合。
 * Spring 为LTW的过程提供了细粒度的控制，它支持在单个ClassLoader范围内实施类文件的转换，且配置更为简单。
 * 在进行下节Spring LTW 的学习之前，先来了解一下JDK 5.0 中引入的Instrument的相关知识，为我们后面的学习打好基础
 * 7.9 java.lang.instrument包的工作原理
 * JDK 5.0 新增了一个java.lang.instrument包，该包中有两个能对JVM底层组件进行访问的类，具体的说，就是通过JVM的-javaagent代理参数在启动
 * 时获取JVM内部组件的引用，以便在后续流程中使用，借助java代理，可以在JVM启动时装配并应用ClassTransformer,对类字节码进行转换，实现AOP
 * 的功能。
 * java.lang.instrument中定义了以下两个重要的接口
 * ClassFileTransformer: Class文件转换器接口，该接口中有一个唯一的方法。
 * byte[] transform(ClassLoader loader,String className,Class<?> classBeingRedfined ,ProtectiongDomain protectionDomain ,byte[] classFileBuffer)
 * 该接口对Class文件字节码进行转换，classfileBuffer 是类文件中对应的字节码数组，返回的byte[] 为转换后的字节码，如果返回为null,则表示不
 * 进行字节码处理，（并非将类的字节码数据置空）
 * Instrumentation : 代表JVM内部一个构件，这个术语不好翻译，它有仪表，仪器，设备等意思，我们不妨将其称为组件
 * 可以通过该接口的方法向JVM的内部组件注册一些ClassFileTransformer,注册转换器的接口方法为void addTransformer(ClassFileTransformer transformer)
 * 当ClassFileTransformer 实例注册到JVM中后，JVM在加载Class文件时，会先调用这个ClassFileTransformer实例的transform()方法对Class文件的
 * 字节码进行转换，如果向JVM中注册多个ClassFileTransformer，它们将按注册的顺序组成链式的调用，这样ClassFileTransFormer的实现者
 * 就可以从JVM层面截获所有类的字节码，并引入希望添加的逻辑，如让每个类拥有性能监视的能力，织入特殊特殊用途的增强代码。
 *
 *
 */
public class TestNamePointcut {




}
