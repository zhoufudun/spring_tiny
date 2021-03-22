package com.spring_1_100.test_81_90.test82_beanfactory;

public class MyBeanFactory {
    /**
     * 1.初始化BeanFactory
     * ConfigurableListableBeanFactory beanFactory = getBeanFactory() ;
     * 初始化BeanFactory: 根据配置文件实例化BeanFactory,getBeanFactory()方法由具体的子类实现，在这一步里，Spring将配置文件的信息装入到
     * 容器的Bean定义注册表（BeanDefinitionRegistry） 中，但是此时Bean还未被初始化。
     * 2.调用工厂后处理器
     * invokeBeanFactoryPostProcessors() ;
     * 调用工厂后处理器，根据反射机制从BeanFactoryRegistry中找到所有的BeanFactoryPostProcessor类型的Bean ,并调用其postProcessBeanFacto()
     * 接口方法
     * 3.注册Bean后处理器
     * registerBeanPostProcessors() ;
     * 注册Bean的后处理器，根据反射机制从BeanDefinitionRegistry中找出所有的BeanPostProcessor类型的Bean,并将他们注册到容器Bean的后
     * 处理器注册表中。
     * 4.初始化消息源
     * initMessageSource() ;
     * 初始化容器的国际化信息资源
     * 5.初始化应用上下文事件广播器
     * initApplicationEventMulticaster() ;
     * 初始化应用上下文事件广播器
     * 6.初始化其他的特殊的Bean,由具体的子类实现
     * 这是一个钩子方法，子类 可以借助这个方法执行一些特殊的操作，如子类可以借助这个方法执行一些特殊的操作，如AbstractRefreshableWebApplicationContext
     * 就可以使用该方法执行初始化ThemeSource操作。
     * onRefresh() ;
     * 7.注册事件监听器
     * registerListeners() ;
     * 8.初始化所有的单例Bean,使用懒初始化模式的Bean除外
     * finishBeanFactoryInitialization(beanFactory);
     * 初始化bean后，将它们放入到Spring容器的缓存中
     * 9.完成刷新并发布容器刷新事件
     * finishRefresh() ;
     * 创建上下文刷新事件，事件广播器负责将这些事件广播到每个注册的事件监听器中。
     * 接口层描述了容器的重要组件及组件间的协作关系。
     * 继承体系逐步实现组件的各项功能。
     * 接口层清晰的勾勒出Spring框架的高层功能，框架脉络呼之欲出，有了接口层的抽象描述后，不但Spring 自己可以提供具体的实现，任何第三方
     * 组织也可以提供不同的实现，可以说，Spring完善的接口层使用框架的扩展性得到了很好的保证，纵向继承体系逐步扩展，分步骤的实现了框架的功能
     * 这种实现方案保证了框架功能不会堆积在某些类的身上，造成过重的代码逻辑负载，框架的复杂度被完美的分解开了。
     * Spring 组件按其所承担的角色可以划分成两类：
     * 1.物料组件 ：Resource,BeanDefinition,PropertyEditor以及最终的Bean等，它们是加工流程中的被加工，被消费的组件 ，就像流水线一样被
     * 加工的物料。
     * 2.加工的设备组件，ResourceLoader，BeanDefinitionReader,BeanFactoryPostProcessor，InstantiationStrategy以及BeanWrapper
     * 等组件像是流水线上的不同的加工设备，对物料组件进行加工。
     * class ,scope ,lazy-init 等配置属性。
     * beanClass,scope,lazyInit 属性，
     *
     * 创建最终的BeanDefinition主要包括两个步骤
     * 1)利用BeanDefinitionReader对配置信息的Resource进行读取，通过XML解析器解析配置信息DOM对象，简单的为每个<bean>生成对应的BeanDefinition
     * 对象，但是这里生成的BeanDefinition是半成品，因为在配置文件中，我们可以通过占位符变量引用外部属性文件的属性，这些占位符变量在这
     * 一步还没有被解析出来。
     * 2)利用容器中注册的BeanFactoryPostProcessor 对半成器的BeanDefinition进行加工处理，将以占位符表示的配置解析为最终的值，这样半成品
     * BeanDefinition就变成了成品的BeanDefinition
     *
     *
     *
     * SimpleInstantiationStrategy策略是最常用的实现类，该策略利用了Bean实现类的默认构造函数，带参数的构造函数或工厂方法创建Bean的实例。
     * CglibSubclassingInstantiationStrategy 扩展了SimpleInstantiationStrategy ，为了需要进行方法的注入bean提供了支持。
     * 它还利用了CGLIB类库为Bean动态生成子类 ，在子类中生成方法注入逻辑，然后使用这个动态生成的子类创建Bean的实例。
     * InstantiationStrategy 仅负责实例化Bean的操作，相当于执行Java语言中的new的功能，它并不会参与Bean的属性设置工作，所以由
     * InstantiationStrategy 返回的Bean实例实际上是一个半成品的Bean的实例，属性填充的工作留给BeanWrapper来完成  。
     * BeanWapper 相当于一个代理器，Spring 通过BeanWrapper 完成Bean属性的填充工作，在Bean实例被InstantiationStrategy创建出来以后
     * 容器的主控程序将Bean实例通过BeanWrapper包装起来。这是通过调用BeanWrapper#setWrapperInstance(Object obj)方法来完成的。BeanWrapper
     * 类继承结构如图所示：
     *
     * BeanWrapper 实现类BeanWrapperImpl 具有三重身份。
     * 1)Bean包裹器
     * 2)属性访问器
     * 3)属性编辑器注册表
     * 一个BeanWrapper实例内部封装了两类组件，被封装的目标Bean以及一套用于设置Bean属性的属性编辑器
     * 要顺利填充Bean属性，除了目标Bean实例和属性编辑器以外，还需要获取Bean对应的BeanDefinition,它从Spring容器的BeanDefinitionRegistry
     * 中直接获取，Spring 主控程序从BeanDefinition获取Bean属性的配置信息PropertyValue，并使用属性编辑器对配置形式的PropertyValue进行
     * 转换以得到Bean的属性值，对Bean其他的属性重复这样的步骤，就可以完成Bean所有的属性的注入工作，BeanWrapperImpl 的内部使用到Spring
     * 的BeanUtils工具类对Bean进行反射操作。设置属性。
     * 不管是double类型还是int类型，在配置文件中都有对应的字符串类型的字面值，BeanWrapper填充Bean属性时如何将这个字面值转换成对应的double
     * 类型或者int等内部类型呢？ 我们可以隐约的感觉到一定有一个转换器在其中作用，这个转换器就是属性编辑器。
     * 属性编辑器这个名字可能会让人误以为是一个用户界面的输入器，其实属性编辑器不一定非得有用户界面，任何实现了java.beans.PropertyEditor
     * 接口的类都是属性编辑器，属性编辑器的主要功能就是将外部设置的值转换成JVM内部对应的类型，属性编辑器其实就是一个类型转换器。
     *
     * Sun所制定的javaBean规范，很大程度上是为了IDE准备的，它让IDE能够以可视化的方式设置JavaBean的属性，如果在IDE中开发一个可视化的应用程序。
     * 我们需要通过属性设置的方式对组成的应用各种组件进行定制，IDE 通过属性编辑器让开发人员使用可视化的方式设置属性。
     * JavaBean规范提供了一个管理默认属性编辑器管理器，PropertyEditorManager ，该管理器内保存着一些常见的类型的属性编辑器，如果某个JavaBean
     * 的觉的属性没有通过BeanInfo显示的指定属性逻辑器，IDE将自动的使用PropertyEditorManager 中注册的对应的默认的属性编辑器。
     * 由于JavaBean对应的属性编辑器IDE环境相关的资源和组件需要动态加载，所以纯Java的IDE中开发基于组件的应用时，总会觉得IDE反应很迟钝。
     * 不像DELphi,C++Build一样灵敏快捷，但是Eclipse开发环境中，设计包括可视化组件的应用时却很快捷，原因是Eclipse没有使用Java标准用户
     * 界面组件库，当然也没有按照JavaBean的规范开发设置GUI组件 。
     *
     * PropertyEditor :
     * PropertyEditor : 是属性编辑器的接口，它规定了将外部设置的值转换成内部javaBean属性值转换的接口方法，PropertyEditor 主要接口方法说明如下？
     * Object getValue() :返回属性的当前值，基本类型被封装成对应的封装类型。
     * void setValue(Object newValue): 设置属性的值，基本 类型以封装类传入。
     * String getAsText() : 将属性对象用一个字符串表示，以便外部的属性编辑器可视化的方式显示，缺省返回null,表示该属性不能以字符串表示。
     * void setAsText(String text) : 用一个字符串去更新属性内部值，这个字符串一般从外部属性编辑器传入。
     * String[] getTags() : 返回表示有效属性值的字符串数组（如boolean属性对应的有效Tag为true和false）,以便属性编辑器能以下拉框的方式
     * 显示出来，缺省返回null,表示属性没有匹配字符值有限集合。
     * String getJavaInitializationString(): 为属性提供一个表示初始化值的字符串，属性编辑器以此值作为属性默认值。
     * 可以看出，PropertyEditor接口方法是内部属性值和外部设置值的沟通桥梁，此外，我们还可以很容易地发现该接口的很多的方法是专专门为IDE
     * 中可视化属性编辑器提供的。如getTags() ,getJavaInitializationString() 以及另外一些我们未此介绍的接口方法。
     * Java 为PropertyEditor 提供了一个方便类，PropertyEditorSupport ，该类实现了PropertyEditor 接口并提供了默认的实现，一般
     * 情况下，用户可以通过扩展这个方便类设计自己的属性编辑器。
     * BeanInfo
     *
     * BeanInfo 主要描述JavaBean哪些属性可以编辑以及对应的属性编辑器，每一个属性对应一个属性描述器PropertyDescriptor,PropertyDescriptor
     * 的构造函数有两个入参，PropertyDescriptor(String propertyName,Class beanClass)，其中propertyName为属性名，而beanClass 为
     * javaBean对应的Class,此外PropertyDescriptor 还有一个setPropertyEditorClass(Class PropertyEditorClass)方法，为JavaBean
     * 属性指定编辑器，BeanInfo 接口最重要的方法就是PropertyDescriptor[] getPropertyDescriptors() ，该方法返回JavaBean的属性描述数组。
     * BeanInfo 接口有一个常用的实现类，SimpleBeanInfo，一般情况下，可能通过扩展的SimpleBeanInfo实现自己的功能。
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {

    }

}
