package com.spring_1_100.test_81_90.test85_init_message;

import org.junit.Test;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.text.html.HTMLDocument;
import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBoundleTest {


    /**
     * 如果应用系统中某些信息需要支持国际化功能，则必需为希望支持的不同的本地化类型分别提供对应的资源文件，并以规范的方式进行命名。国际
     * 化资源文件的命名规范支付宝资源名称采用以下的方式进行命名。
     * <资源名>_<语言代码>_<国家/地区代码>.properties
     * 其中，语言代码和国家/地区代码都是可选的，<资源名>.properties命名的国际化资源文件默认资源文件，即某个本地化类型在系统中找不到对应的
     * 资源文件，就采用这个默认的资源文件，<资源名>_<语言代码>.properties命名的国际化资源文件是某一语言默认的资源文件，即某个本地化在系统中
     * 找不到精确的匹配资源文件，将采用相应的语言默认的资源文件，
     * 举一个例子，假设资源名为resource,则语言为英文，国家为美国，则与其对应本地资源文名为resource_en_US.properties，信息在资源文件以
     * 属性名值方式表示。
     *
     *
     */
    @Test
    public void test1() {
        ResourceBundle rb1 = ResourceBundle.getBundle("spring_1_100/config_81_90/spring85_resource_locale/resource", Locale.US);
        ResourceBundle rb2 = ResourceBundle.getBundle("spring_1_100/config_81_90/spring85_resource_locale/resource", Locale.CHINA);
        System.out.println("us:"+rb1.getString("greeting.common"));
        System.out.println("zn:"+rb2.getString("greeting.common"));

    }


    @Test
    public void test2() {
        ResourceBundle rb1 = ResourceBundle.getBundle("spring_1_100/config_81_90/spring85_resource_locale/resource", Locale.US);
        ResourceBundle rb2 = ResourceBundle.getBundle("spring_1_100/config_81_90/spring85_resource_locale/resource", Locale.CHINA);
        Object[] params = {"John",new GregorianCalendar().getTime()};

        String str1 = new MessageFormat(rb1.getString("greeting.common"),Locale.US).format(params);
        String str2 = new MessageFormat(rb2.getString("greeting.common"),Locale.CHINA).format(params);
        System.out.println(str1);
        System.out.println(str2);

    }



    @Test
    public void test3() {

        String [] configs = {"spring_1_100/config_81_90/spring85_resource_locale/spring85_resouce.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        MessageSource ms = (MessageSource) ctx.getBean("myResource");

        Object[] params = {"Joxxxxhn",new GregorianCalendar().getTime()};

        String str1 = ms.getMessage("greeting.common",params,Locale.US);
        String str2 = ms.getMessage("greeting.common",params,Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);

    }



    @Test
    public void test4() throws Exception{

        String [] configs = {"spring_1_100/config_81_90/spring85_resource_locale/spring85_resouce.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        MessageSource ms = (MessageSource) ctx.getBean("myReloadingResource");

        Object[] params = {"Joxxxxhn",new GregorianCalendar().getTime()};

        for(int i = 0;i < 2;i++){
            String str1 = ms.getMessage("greeting.common",params,Locale.US);
            String str2 = ms.getMessage("greeting.common",params,Locale.CHINA);
            System.out.println(str1);
            System.out.println(str2);
            Thread.currentThread().sleep(10000);
        }

    }
}
