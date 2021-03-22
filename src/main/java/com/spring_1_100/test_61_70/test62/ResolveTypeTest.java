package com.spring_1_100.test_61_70.test62;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResolveTypeTest {

    private Service<Double, Float> service;
    private List<List<String>> list;
    private Map<String, Map<String, Integer>> map;
    private List<String>[] array;

    interface Service<N, M> {

    }


    class ServiceImpl<A, B> implements Service<String, Integer> {
        public ServiceImpl(List<List<String>> list, Map<Double, Map<Float, Integer>> map) {
        }
    }


    @Test
    public void forClassTest() {
        ResolvableType resolvableType = ResolvableType.forClass(ServiceImpl.class);
        // getType 保存原始的 Type 类型
        System.out.println( resolvableType.getType());
        // resolve 将 Type 解析为 Class， 如果无法解析返回 null
        System.out.println(resolvableType.resolve());
    }

    @Test
    public void forFieldTest() {
        // 1. Service<Double, Float> service
        Field filed = ReflectionUtils.findField(ResolveTypeTest.class, "service");


        ResolvableType resolvableType = ResolvableType.forField(filed);
        // getType() 保存原始的 Type 类型
        Assert.assertEquals(filed.getGenericType(), resolvableType.getType());
        System.out.println(resolvableType.getType());

        // resolve() 对于 ParameterizedType 类型保存的是 <> 之前的类型，即 Service.class
        Assert.assertEquals(((ParameterizedType) filed.getGenericType()).getRawType(), resolvableType.resolve());
        System.out.println(resolvableType.resolve());

        ResolvableType resolvableType1 = resolvableType.getGeneric();
       // Assert.assertEquals(Double.class, clazz);
        System.out.println("======="+resolvableType1);

        /*// 2. List<List<String>> list
        resolvableType = ResolvableType.forField(
                ReflectionUtils.findField(ResolveTypeTest.class, "list"));
        // 下面两种获取泛型的方式等价
        clazz = resolvableType.getGeneric(0).getGeneric(0).resolve();
        Assert.assertEquals(String.class, clazz);
        clazz = resolvableType.getGeneric(0, 0).resolve();
        Assert.assertEquals(String.class, clazz);

        // 3. Map<String, Map<String, Integer>> map
        resolvableType = ResolvableType.forField(
                ReflectionUtils.findField(ResolveTypeTest.class, "map"));
        clazz = resolvableType.getGeneric(1).getGeneric(1).resolve();
        Assert.assertEquals(Integer.class, clazz);

        // 4. List<String>[] array
        resolvableType = ResolvableType.forField(
                ReflectionUtils.findField(ResolveTypeTest.class, "array"));
        Assert.assertTrue(resolvableType.isArray());
        Assert.assertEquals(List.class, resolvableType.getComponentType().resolve());
        Assert.assertEquals(String.class, resolvableType.getComponentType().getGeneric(0).resolve());*/
    }





    @Test
    public void forMethodTest() {
        // 1. 方法的返回值类型
        ResolvableType returnType = ResolvableType.forMethodReturnType(
                ReflectionUtils.findMethod(ServiceImpl.class, "method"));

        Assert.assertEquals(Double.class, returnType.getGeneric(1, 0).resolve());

        // 2. 构造器 ServiceImpl(List<List<String>> list, Map<Double, Map<Float, Integer>> map)
        ResolvableType parameterType = ResolvableType.forConstructorParameter(
                ClassUtils.getConstructorIfAvailable(ServiceImpl.class, List.class, Map.class), 0);
        // List<List<String>> 的泛型第一层为 <List<String>>，第二层为 <String>
        Assert.assertEquals(String.class, parameterType.getGeneric(0, 0).resolve());

        parameterType = ResolvableType.forConstructorParameter(
                ClassUtils.getConstructorIfAvailable(ServiceImpl.class, List.class, Map.class), 1);
        Assert.assertEquals(Double.class, parameterType.getGeneric(0).resolve());
        Assert.assertEquals(Float.class, parameterType.getGeneric(1, 0).resolve());
        Assert.assertEquals(Integer.class, parameterType.getGeneric(1, 1).resolve());
    }




    @Test
    public void test1() {
        // HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
        ResolvableType resolvableType = ResolvableType.forClass(HashMap.class);
        // 1. getInterfaces 获取接口
        Assert.assertEquals(Map.class, resolvableType.getInterfaces()[0].resolve());

        // 2. getSuperType 获取父类
        Assert.assertEquals(AbstractMap.class, resolvableType.getSuperType().resolve());

        // 3. as 向上转型 Map<K,V>
        ResolvableType mapResolvableType = resolvableType.as(Map.class);
        Assert.assertEquals(Map.class, mapResolvableType.resolve());

        // 4. getRawClass 当 type 是 ParameterizedType 时有效
        Assert.assertEquals(Map.class, mapResolvableType.getRawClass());
        Assert.assertEquals(HashMap.class.getGenericInterfaces()[0], mapResolvableType.getType());
        System.out.println(mapResolvableType.getType());

        // 5. getGeneric 获取泛型 class ServiceImpl<A, B> implements Service<String, Integer>
        resolvableType = ResolvableType.forClass(ServiceImpl.class);
        // 当 Type 无法找到具体的 class 类型时返回 null
        //Assert.assertEquals("A", resolvableType.getGeneric(0).getType().getTypeName());
        Assert.assertEquals(null, resolvableType.getGeneric(0).resolve());


        // 以下两种获取泛型的 Class 类型方式等价
        Assert.assertEquals(String.class, resolvableType.as(Service.class).getGeneric(0).resolve());
        Assert.assertEquals(String.class, resolvableType.as(Service.class).resolveGeneric(0));

        // 5. getComponentType 获取数组泛型 List<String>[] array
        resolvableType = ResolvableType.forField(
                ReflectionUtils.findField(ResolveTypeTest.class, "array"));
        Assert.assertEquals(List.class, resolvableType.getComponentType().resolve());
    }



    @Test
    public void test2() {
        ResolvableType resolvableType1 = ResolvableType.forClassWithGenerics(List.class, String.class);
        ResolvableType resolvableType2 = ResolvableType.forArrayComponent(resolvableType1);
        resolvableType2.getComponentType().getGeneric(0).resolve();

        // List<String>[] array
        ResolvableType resolvableType3 = ResolvableType.forField(
                ReflectionUtils.findField(ResolveTypeTest.class, "array"));
        Assert.assertTrue(resolvableType3.isAssignableFrom(resolvableType2));

        Assert.assertTrue(ResolvableType.forClass(Object.class).isAssignableFrom(
                ResolvableType.forClass(String.class)));
    }
}
