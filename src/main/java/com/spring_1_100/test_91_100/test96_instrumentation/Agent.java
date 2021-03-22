package com.spring_1_100.test_91_100.test96_instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/***
 * 使用JVM启动参数注册转换器问题
 * 虽然可以通过-javaagent参数向JVM注册转换器，并对JVM中的类实施影响，但转换器会对JVM所有的类都产生影响，这往往不是我们所期望的。如一个
 * Web应用服务器上可能部署多个Web应用，如果使用-javaagent 注册转换器，虽然不同的Web应用对就不同的ClassLoader，但转换器依旧会对不同的
 * ClassLoader下所有的类产生影响，此外，使用JVM 启动参数注册转换器，实际操作上比较麻烦，给应用程序部署带来不便
 *
 * Spring 的org.springframework.instrument.classloading.LoadTimeWeaver接口规定了类加载期织入器高层协义，接口有3个方法
 * void addTransformer(ClassFileTransformer transformer ) : 添加了一个ClassFileTransformer 到加载期织入器中。
 * ClassLoader getInstrumentableClassLoader()  ： 我们知道JVM拥有instrumentation 组件，但这是JVM级别的Spring对ClassLoader
 * 进行扩展，让它也具有instrumentation组件，以便对ClassLoader中的类应用ClassFileTransformer
 * ClassLoader getThrowawayClassLoader() : 返回一个丢弃的ClassLoader，目的是使instrumentation 的作用范围公尺局限在
 * ClassLoader中，而不影响父ClassLoader Spring 为LoadTimeWeaver 提供了多个实现类。
 * InstrumentationLoadTimeWeaver: 该装载期织入器使用-javaagent
 * SimpleLoadTimeWeaver : 该装载器织入能为当前的ClassLoader 创建一个相应的SimpleInstrumentableClassLoader 简单组件使能ClassLoader
 * 实现类，一般在测试或IDE环境下使用。
 * 特定Web服务器的织入器：JBossLoadTimeWeaver (在JBoss AS 5.0 以上版本使用) GlassFishLoadTimeWeaver (在GlassFish3.0 以下版本使用)
 * BEA WebLogic 10.0 以上版本使用，OC4JLoadTimeWeaver 在Oracle OC4J 10.1.3.1以上版本使用。
 * ReflectiveLoadTimeWeaver : 有一些应用服务器不是组件使能的ClassLoader ，或者虽然是组件使能,但却无法获取应用服务器的类加载器实例，
 * 用户只能以ClassLoader 类型获取这些类加载的句柄，在这种情况下，Spring 没有办法将转换器添加到ClassLoader中，这时，只得对目标的ClassLoader
 * 进行改造，让它实现一些特殊的方法，并由ReflectiveLoadTimeWeaver 在运行期通过反射机制调用接口方法，以便注册ClassFileTransformer，可以
 * 扩展需要改造的ClassLoader类，并实现以下两个特殊方法达到目的，
 * 1)public void addTransformer(java.lang.instrument.ClassFileTransformer): 向ClassLoader中注册转换器。
 * 2)public ClassLoader getThrowawayClassLoader():返回需要丢弃的ClassLoader Spring 只需要在配置文件中添加一行配置就可以启用LoadTimeWeaver
 *
 *
 *
 */
public class Agent {
    public static void premain(String agentArgs, Instrumentation inst){
        ClassFileTransformer t = new Transformer();
        inst.addTransformer(t);
    }
}
