package com.spring_101_200.test_111_120.test_111_cglib_proxy;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class SpringCglib {

    private static final Class<?>[] CALLBACK_TYPES = new Class<?>[]
            {NoOp.class, LookupOverrideMethodInterceptor.class, ReplaceOverrideMethodInterceptor.class};

    public Object getInstance(Class<?> clazz,int index) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallbacks(new Callback[]{NoOp.INSTANCE,new LookupOverrideMethodInterceptor(),new ReplaceOverrideMethodInterceptor()});
        enhancer.setCallbackFilter(new MethodOverrideCallbackFilter(index));
        enhancer.setCallbackTypes(CALLBACK_TYPES);
        return enhancer.create();
    }


    class MethodOverrideCallbackFilter implements CallbackFilter {
        private int a;
        public MethodOverrideCallbackFilter(int a) {
            this.a = a;
        }
        @Override
        public int accept(Method method) {
            return a;
        }
    }


    class LookupOverrideMethodInterceptor  implements MethodInterceptor {
        public LookupOverrideMethodInterceptor() {

        }
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy mp) throws Throwable {
            System.out.println("======lookup=====start===========");
            Object xxxx = mp.invokeSuper(obj, args);
            System.out.println("======lookup=====end=======");
            return null;
        }
    }

    class ReplaceOverrideMethodInterceptor implements MethodInterceptor {
        public ReplaceOverrideMethodInterceptor() {
        }
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy mp) throws Throwable {
            System.out.println("======replace=====start===");
            Object xxxx = mp.invokeSuper(obj, args);
            System.out.println("======replace=====end=====");
            return null;
        }
    }



}
