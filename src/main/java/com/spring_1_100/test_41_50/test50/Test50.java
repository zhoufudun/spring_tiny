package com.spring_1_100.test_41_50.test50;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.asm.ClassReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Test50 {





    @Test
   public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring50.xml");
        //获取动态Bean
        Stu stu =(Stu) ac.getBean("dynamicStu");
        System.out.println(JSON.toJSONString(stu));
    }




    @Test
    public void inspectClass() {
        Class<?> clazz = StuFactory.class;
        InputStream is = clazz.getResourceAsStream(ClassUtils.getClassFileName(clazz));
        if (is == null) {

        }
        try {
            ClassReader classReader = new ClassReader(is);
            Map<Member, String[]> map = new ConcurrentHashMap<Member, String[]>(32);
            classReader.accept(new MyLocalVariableTableParameterNameDiscoverer.ParameterNameDiscoveringVisitor(clazz, map), 0);
            System.out.println(JSON.toJSONString(map));

        }
        catch (IOException ex) {

        }
        finally {
            try {
                is.close();
            }
            catch (IOException ex) {
                // ignore
            }
        }
    }






    @Test
    public void test3() throws Exception{
        StuFactory factoryBean = new StuFactory();
        Method [] a = StuFactory.class.getDeclaredMethods();
        for(Method m : a ){
            System.out.println(m.getName());
            Object c =  m.invoke(factoryBean, "11");
            System.out.println(c );
        }
        //
    }
}