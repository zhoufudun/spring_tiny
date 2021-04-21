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

import java.rmi.Remote;

/**
 * Interface for RMI invocation handlers instances on the server,
 * wrapping exported services. A client uses a stub implementing
 * this interface to access such a service.
 *
 * <p>This is an SPI interface, not to be used directly by applications.
 *
 * @author Juergen Hoeller
 * @since 14.05.2003
 */
public interface MyRmiInvocationHandler extends Remote {


    Object invoke(MyRemoteInvocation invocation) throws Exception;

}
