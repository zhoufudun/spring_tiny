package com.spring_101_200.test_111_120.test_113_conversion;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Type;

public class A<T>{
	protected String namespace;
	public A(){
		Type type = getClass().getGenericSuperclass();
		ResolvableType t=ResolvableType.forType(type);
		namespace=t.getGeneric(0).resolve().getName();
	}
}


