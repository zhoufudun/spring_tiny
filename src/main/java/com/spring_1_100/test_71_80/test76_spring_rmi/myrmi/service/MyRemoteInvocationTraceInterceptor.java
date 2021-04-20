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

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyRemoteInvocationTraceInterceptor implements MethodInterceptor {

    public MyRemoteInvocationTraceInterceptor() {

    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            Object retVal = invocation.proceed();
            return retVal;
        } catch (Throwable ex) {
            throw ex;
        }
    }

}
