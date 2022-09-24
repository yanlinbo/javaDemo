package com.ylb.demoTest.springTest;

import com.ylb.config.AppConfig;
import com.ylb.domin.Study;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

public class AnnotatedBeanDefinitionReaderTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        // 将User.class解析为BeanDefinition
         annotatedBeanDefinitionReader.register(Study.class);
//         System.out.println(context.getBean("study"));

//        System.out.println(context.getMessage("apple", null, new Locale("en_CN")));
//        ApplicationContext applicationContex = new AnnotationConfigApplicationContext();

        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        System.out.println(systemEnvironment);
        context.publishEvent("kkk");

    }
}
