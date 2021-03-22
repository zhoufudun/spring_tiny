package com.spring_101_200.test_191_200.test_197_directFieldAccessor;

import org.junit.Test;
import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.convert.TypeDescriptor;

public class Test197 {
    //在项目中遇到某实例中的某个属性被声明为private ,而且实体类中，不提供该属性的get方法，导致无法通过get获取该属性值。这个时候，我们可以利用DirectFieldAccessor这个类进行获取我们想要的属性值。
    @Test
    public void testDirectFieldAccessor() {
        User user = new User(111);

        DirectFieldAccessor accessor = new DirectFieldAccessor(user);
        TypeDescriptor id = accessor.getPropertyTypeDescriptor("id");
        System.out.println(id.getName());
        Object idValue = accessor.getPropertyValue("id");
        System.out.println("idValue:" +idValue);

        Ving ving = (Ving)accessor.getPropertyValue("ving");
        System.out.println(ving.activeCount);

    }


    @Test
    public void testPropertyAccessorFactory() {
        User user = new User(111);

        ConfigurablePropertyAccessor configurablePropertyAccessor = PropertyAccessorFactory.forDirectFieldAccess(user);

        TypeDescriptor id = configurablePropertyAccessor.getPropertyTypeDescriptor("id");

        System.out.println(id.getName());

        Object idValue = configurablePropertyAccessor.getPropertyValue("id");
        System.out.println("idValue:" +idValue);

        Ving ving = (Ving)configurablePropertyAccessor.getPropertyValue("ving");
        System.out.println(ving.activeCount);


    }
}
