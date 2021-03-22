/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spring_1_100.test_41_50.test44;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.StaticApplicationContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

/**
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Chris Beams
 */
public class QualifierAnnotationTests {

    private static final String CLASSNAME = QualifierAnnotationTests.class.getName();
    private static final String CONFIG_LOCATION = "classpath:spring44.xml";

    public static void main(String[] args) {

        //testQualifiedByValue();
        testQualifiedByCustomValue();
    }


    public static void testNonQualifiedFieldFails() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", NonQualifiedTestBean.class);
    }

    public static void testQualifiedByValue() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByValueTestBean.class);
        context.refresh();
        QualifiedByValueTestBean testBean = (QualifiedByValueTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();

        System.out.println(person.getName());
    }

    public static void testQualifiedByParentValue() {
        StaticApplicationContext parent = new StaticApplicationContext();

        GenericBeanDefinition parentLarry = new GenericBeanDefinition();
        parentLarry.setBeanClass(Person.class);
        parentLarry.getPropertyValues().add("name", "ParentLarry1111111111");
        parentLarry.addQualifier(new AutowireCandidateQualifier(Qualifier.class, "parentLarry"));
        parent.registerBeanDefinition("someLarry", parentLarry);

        GenericBeanDefinition otherLarry = new GenericBeanDefinition();
        otherLarry.setBeanClass(Person.class);
        otherLarry.getPropertyValues().add("name", "OtherLarry2222222222");
        otherLarry.addQualifier(new AutowireCandidateQualifier(Qualifier.class, "otherLarry"));
        parent.registerBeanDefinition("someOtherLarry", otherLarry);

        parent.refresh();
        StaticApplicationContext context = new StaticApplicationContext(parent);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByParentValueTestBean.class);
        context.refresh();

        QualifiedByParentValueTestBean testBean = (QualifiedByParentValueTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();
        System.out.println(person.getName());
    }

    public static void testQualifiedByBeanName() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByBeanNameTestBean.class);
        context.refresh();
        QualifiedByBeanNameTestBean testBean = (QualifiedByBeanNameTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();
        System.out.println(person.getName());
        System.out.println(testBean.myProps);
    }

    public void testQualifiedByFieldName() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByFieldNameTestBean.class);
        context.refresh();
        QualifiedByFieldNameTestBean testBean = (QualifiedByFieldNameTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();
        System.out.println(person.getName());
    }

    public void testQualifiedByParameterName() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByParameterNameTestBean.class);
        context.refresh();
        QualifiedByParameterNameTestBean testBean = (QualifiedByParameterNameTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();
        System.out.println(person.getName());
    }

    public void testQualifiedByAlias() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByAliasTestBean.class);
        context.refresh();
        QualifiedByAliasTestBean testBean = (QualifiedByAliasTestBean) context.getBean("testBean");
        Person person = testBean.getStooge();

        System.out.println(person.getName());
    }

    public void testQualifiedByAnnotation() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByAnnotationTestBean.class);
        context.refresh();
        QualifiedByAnnotationTestBean testBean = (QualifiedByAnnotationTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();

        System.out.println(person.getName());
    }

    public static  void testQualifiedByCustomValue() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByCustomValueTestBean.class);
        context.refresh();
        QualifiedByCustomValueTestBean testBean = (QualifiedByCustomValueTestBean) context.getBean("testBean");
        Person person = testBean.getCurly();
        System.out.println(person.getName());
    }

    public void testQualifiedByAnnotationValue() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        context.registerSingleton("testBean", QualifiedByAnnotationValueTestBean.class);
        context.refresh();
        QualifiedByAnnotationValueTestBean testBean = (QualifiedByAnnotationValueTestBean) context.getBean("testBean");
        Person person = testBean.getLarry();
        System.out.println(person.getName());
    }

    public static void testQualifiedByAttributesFailsWithoutCustomQualifierRegistered() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);

        context.registerSingleton("testBean", QualifiedByAttributesTestBean.class);

        QualifiedByAttributesTestBean testBean = (QualifiedByAttributesTestBean) context.getBean("testBean");


        System.out.println(testBean.getMoeJunior().getName());
        System.out.println(testBean.getMoeSenior().getName());



    }

    public void testQualifiedByAttributesWithCustomQualifierRegistered() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
        QualifierAnnotationAutowireCandidateResolver resolver = (QualifierAnnotationAutowireCandidateResolver)
                context.getDefaultListableBeanFactory().getAutowireCandidateResolver();
        resolver.addQualifierType(MultipleAttributeQualifier.class);

        context.registerSingleton("testBean", MultiQualifierClient.class);
        context.refresh();

        MultiQualifierClient testBean = (MultiQualifierClient) context.getBean("testBean");

        System.out.println(testBean.factoryTheta);
        System.out.println(testBean.implTheta);
    }

    public void testInterfaceWithOneQualifiedFactoryAndOneQualifiedBean() {
        StaticApplicationContext context = new StaticApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(CONFIG_LOCATION);
    }


    @SuppressWarnings("unused")
    private static class NonQualifiedTestBean {

        @Autowired
        private Person anonymous;

        public Person getAnonymous() {
            return anonymous;
        }
    }


    private static class QualifiedByValueTestBean {

        @Autowired
        @Qualifier("larry")
        private Person larry;

        public Person getLarry() {
            return larry;
        }
    }


    private static class QualifiedByParentValueTestBean {

        @Autowired
        @Qualifier("parentLarry")
        private Person larry;

        public Person getLarry() {
            return larry;
        }
    }


    private static class QualifiedByBeanNameTestBean {

        @Autowired
        @Qualifier("larryBean")
        private Person larry;

        @Autowired
        @Qualifier("testProperties")
        public Properties myProps;

        public Person getLarry() {
            return larry;
        }
    }


    private static class QualifiedByFieldNameTestBean {

        @Autowired
        private Person larryBean;

        public Person getLarry() {
            return larryBean;
        }
    }


    private static class QualifiedByParameterNameTestBean {

        private Person larryBean;

        @Autowired
        public void setLarryBean(Person larryBean) {
            this.larryBean = larryBean;
        }

        public Person getLarry() {
            return larryBean;
        }
    }


    private static class QualifiedByAliasTestBean {

        @Autowired
        @Qualifier("stooge")
        private Person stooge;

        public Person getStooge() {
            return stooge;
        }
    }


    private static class QualifiedByAnnotationTestBean {

        @Autowired
        @Qualifier("special")
        private Person larry;

        public Person getLarry() {
            return larry;
        }
    }


    private static class QualifiedByCustomValueTestBean {

        @Autowired
        @SimpleValueQualifier("curly")
        private Person curly;

        public Person getCurly() {
            return curly;
        }
    }


    private static class QualifiedByAnnotationValueTestBean {

        @Autowired
        @SimpleValueQualifier("special")
        private Person larry;

        public Person getLarry() {
            return larry;
        }
    }


    @SuppressWarnings("unused")
    private static class QualifiedByAttributesTestBean {

        @Autowired
        @MultipleAttributeQualifier(name = "moe", age = 15)
        private Person moeSenior;

        @Autowired
        @MultipleAttributeQualifier(name = "bbbbbbbb", age = 2000)
        private Person moeJunior;

        public Person getMoeSenior() {

            return moeSenior;
        }

        public Person getMoeJunior() {
            return moeJunior;
        }
    }


    @SuppressWarnings("unused")
    private static class Person {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @Qualifier("special")
    @SimpleValueQualifier("special")
    private static class SpecialPerson extends Person {
    }


    @Target({ElementType.FIELD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Qualifier
    public @interface SimpleValueQualifier {

        String value() default "";
    }


    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MultipleAttributeQualifier {

        String name();

        int age();
    }


    private static final String FACTORY_QUALIFIER = "FACTORY";

    private static final String IMPL_QUALIFIER = "IMPL";


    public static class MultiQualifierClient {

        @Autowired
        @Qualifier(FACTORY_QUALIFIER)
        public Theta factoryTheta;

        @Autowired
        @Qualifier(IMPL_QUALIFIER)
        public Theta implTheta;
    }


    public interface Theta {
    }


    @Qualifier(IMPL_QUALIFIER)
    public static class ThetaImpl implements Theta {
    }


    @Qualifier(FACTORY_QUALIFIER)
    public static class QualifiedFactoryBean implements FactoryBean<Theta> {

        @Override
        public Theta getObject() {
            return new Theta() {
            };
        }

        @Override
        public Class<Theta> getObjectType() {
            return Theta.class;
        }

        @Override
        public boolean isSingleton() {
            return true;
        }
    }

}
