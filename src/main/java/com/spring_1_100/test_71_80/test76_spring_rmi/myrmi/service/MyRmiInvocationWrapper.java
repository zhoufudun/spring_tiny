/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.service;

import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.MyRemoteInvocation;

import java.lang.reflect.Method;

public class MyRmiInvocationWrapper implements MyRmiInvocationHandler {

    private final Object wrappedObject;

    public MyRmiInvocationWrapper(Object wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public Object invoke(MyRemoteInvocation invocation) throws Exception {
        Method method = this.wrappedObject.getClass().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
        return method.invoke(this.wrappedObject, invocation.getArguments());
    }

}
