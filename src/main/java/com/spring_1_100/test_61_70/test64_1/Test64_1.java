package com.spring_1_100.test_61_70.test64_1;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

@MyAnnotation(xxxx = "bbbbbbbbb")
public class Test64_1 {


    @Test
    public void test() {
        AliasTest aliasTest  = new AliasTest();
        ParentMyAnnotation myAnnotation = AnnotationUtils.getAnnotation(aliasTest.getClass(), ParentMyAnnotation.class);
        System.out.println("aaaa:" + myAnnotation.aaaa() + ";bbbb:" + myAnnotation.bbbb());
    }



    @Test
    public void test1() {
        AliasTest1 aliasTest  = new AliasTest1();
        ParentMyAnnotation myAnnotation = AnnotationUtils.getAnnotation(aliasTest.getClass(), ParentMyAnnotation.class);
        //System.out.println("aaaa:" + myAnnotation.aaaa() + ";bbbb:" + myAnnotation.bbbb());
    }


    @Test
    public void test2() {
        AliasTest2 aliasTest  = new AliasTest2();
        MyAnnotation myAnnotation = AnnotationUtils.getAnnotation(aliasTest.getClass(), MyAnnotation.class);
        System.out.println("xxxx:" + myAnnotation.xxxx() + ";yyyy:" + myAnnotation.yyyy());
    }



    @Test
    public void test3()  throws Exception{
        MyAliasClass myAliasTest = new MyAliasClass();
        SubMyAnnotation myAnnotation = AnnotationUtils.getAnnotation(myAliasTest.getClass(), SubMyAnnotation.class);
        System.out.println("iiii:" + myAnnotation.iiii() + ";jjjj:" + myAnnotation.jjjj());
    }

    @Test
    public void testbb()  throws Exception{
        MyAnnotation myAnnotation = AnnotationUtils.getAnnotation(this.getClass(), MyAnnotation.class);
        System.out.println("value:" + myAnnotation.yyyy() + ";loation:" + myAnnotation.xxxx());
    }
}