package com.spring_1_100.test_1_10.test4_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Exception {
        //通过类装载器获取 Car 类对象
        // 类装载器就是寻找类的字节码文件并构造出类在 JVM 内部表示对象的组件，在 Java 中类装载器把一个类装入 JVM 中需要经过以下的步骤
        // 1.装载，查找和导入 Class 文件
        // 2.链接，执行校验，准备，解析步骤，其中解析步骤是可以选择的
        //   a) 校验：检查载入的 Class 文件数据正确性
        //   b) 准备：给类的静态变量分配存储空间
        //   c) 解析：将符号引用转成直接引用
        // 3.初始化：对类的静态变量，静态代码执行初始化工作
        // 类装载工作由 ClassLoader 及其子类负责，ClassLoader 是一个重要的 java 运行系统组件 ，它负责在运行时查找和装入 Class 字节码文件
        //
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.spring_1_100.test_1_10.test4_reflect.Car");
        // 获取类默认的构造器对象并通过它实例化 Car
        Constructor cons = clazz.getDeclaredConstructor(null);
        Car car = (Car) cons.newInstance();

        // 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗 CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "红色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Exception {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
