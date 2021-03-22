package com.spring_1_100.test_81_90.test83_property_editor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ChartBeanBeanInfo extends SimpleBeanInfo {

    /**
     * Spring 的属性编辑器和传统的用于IDE开发时属性编辑器不同，它们没有UI界面，仅负责将配置文件中的文本配置值转换成Bean属性对应的值。
     * 所以Spring的属性编辑器并非传统意义上的JavaBean属性编辑器。
     * Spring为常见的属性类型提供了默认的属性编辑器，我BeanWrapperImpl类扩展了PropertyEditorRegistrySupport类，Spring在PropertyEditorRegistrySupport
     * 中为常见的属性类型提供了默认的属性编辑器，这些常见的类型共32个，可以分成3大类。总结如下：
     * 基础数据类型：
     * 分为几个小类：
     * 1) 基本数据类型，如boolean ,byte,short,int等
     * 2) 基本数据类型封装类，如：Long,Character,Integer等
     * 3) 两个基本数据类型数组，char[]和byte[]
     * 4) 大数类 ，BigDecimal和BigInteger .
     * PropertyEditorRegistrySupport中有两个用于保存属性编辑器的Map类型的变量：
     * DefaultEditors :用于保存默认的属性类型的编辑器，元素的键为属性类型，值为对应的属性编辑器实例。
     * customEditors: 用于保存用户自定义的属性编辑器，元素的键值和defaultEditors 相同。
     * this.defaultEditors.put(char.class,new CharacterEditor(false));
     * this.defaultEditors.put(Character.class,new CharacterEditor(true));
     * this.defaultEditors.put(Locale.class,new LocaleEditor());
     * this.defaultEditors.put(Properties.class,new PropertiesEditor());
     * 这些默认的属性编辑器解决常见的属性类型注册问题，如果用户的应用包括一些特殊的类型的属性，且希望在配置文件中以字面值提供配置值。
     * 那么就需编写自定义属性编辑器并注册到Spring容器中，这样，Spring才能将配置文件中属性配置值转换为对应的属性类型值。
     * Spring 大部分默认属性编辑器都直接扩展于java.beans.PropertyEditorSupport类，用户也可以通过扩展PropertyEditorSupport实现自己的
     * 属性编辑器。比起用于IDE 环境的属性编辑器来说，Spring 环境下使用的属性编辑器的功能非常单一，仅需要将配置文件中字面值转换为属性类型
     * 对象即可，并不需要提供UI 界面，因此仅需要简单的覆盖PropertyEditorSupport 的setAsText()方法就可以了。
     *
     * @return
     */
    @Override
    public PropertyDescriptor [] getPropertyDescriptors(){
        try {
            PropertyDescriptor titlePositionDescriptor = new PropertyDescriptor("titlePostion",ChartBean.class);
            titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
            return new PropertyDescriptor[] {titlePositionDescriptor};
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
