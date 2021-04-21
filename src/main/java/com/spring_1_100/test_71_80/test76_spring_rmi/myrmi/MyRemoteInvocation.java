package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi;

import java.io.Serializable;

public class MyRemoteInvocation  implements Serializable {

    /** use serialVersionUID from Spring 1.1 for interoperability */
    private static final long serialVersionUID = 6876024250231820554L;


    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] arguments;



    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }
}
