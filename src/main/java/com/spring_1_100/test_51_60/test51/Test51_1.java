package com.spring_1_100.test_51_60.test51;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class Test51_1 {


    public static
    final Set<Class<? extends Annotation>> autowiredAnnotationTypes =
            new LinkedHashSet<Class<? extends Annotation>>();


    public static String requiredParameterName = "required";

    public static boolean requiredParameterValue = true;


    public static void main(String[] args) {
        buildAutowiringMetadata(Test51.class);
    }



    public static InjectionMetadata buildAutowiringMetadata(final Class<?> clazz) {
        LinkedList<InjectionMetadata.InjectedElement> elements = new LinkedList<InjectionMetadata.InjectedElement>();
        Class<?> targetClass = clazz;

        do {
            final LinkedList<InjectionMetadata.InjectedElement> currElements =
                    new LinkedList<InjectionMetadata.InjectedElement>();

            ReflectionUtils.doWithLocalFields(targetClass, new ReflectionUtils.FieldCallback() {
                @Override
                public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                    AnnotationAttributes ann = findAutowiredAnnotation(field);
                    if (ann != null) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            return;
                        }
                        System.out.println(JSON.toJSONString(ann));
                        boolean required = determineRequiredStatus(ann);
                    }
                }
            });

            ReflectionUtils.doWithLocalMethods(targetClass, new ReflectionUtils.MethodCallback() {
                @Override
                public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                    Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(method);
                    if (!BridgeMethodResolver.isVisibilityBridgeMethodPair(method, bridgedMethod)) {
                        return;
                    }
                    AnnotationAttributes ann = findAutowiredAnnotation(bridgedMethod);
                    if (ann != null && method.equals(ClassUtils.getMostSpecificMethod(method, clazz))) {
                        if (Modifier.isStatic(method.getModifiers())) {
                            return;
                        }
                        if (method.getParameterTypes().length == 0) {
                        }
                        boolean required = determineRequiredStatus(ann);
                        PropertyDescriptor pd = BeanUtils.findPropertyForMethod(bridgedMethod, clazz);
                        System.out.println(JSON.toJSONString(pd));
                    }
                }
            });

            elements.addAll(0, currElements);
            targetClass = targetClass.getSuperclass();
        }
        while (targetClass != null && targetClass != Object.class);

        return new InjectionMetadata(clazz, elements);
    }


    public static AnnotationAttributes findAutowiredAnnotation(AccessibleObject ao) {
        for (Class<? extends Annotation> type : autowiredAnnotationTypes) {
            AnnotationAttributes attributes = AnnotatedElementUtils.getMergedAnnotationAttributes(ao, type);
            if (attributes != null) {
                return attributes;
            }
        }
        return null;
    }




    /**
     * Determine if the annotated field or method requires its dependency.
     * <p>A 'required' dependency means that autowiring should fail when no beans
     * are found. Otherwise, the autowiring process will simply bypass the field
     * or method when no beans are found.
     * @param ann the Autowired annotation
     * @return whether the annotation indicates that a dependency is required
     */
    public static boolean determineRequiredStatus(AnnotationAttributes ann) {
        return (!ann.containsKey(requiredParameterName) ||
                requiredParameterValue == ann.getBoolean(requiredParameterName));
    }



}
