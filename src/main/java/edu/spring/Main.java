package edu.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ClassConfig.class);

        Hello hello = context.getBean(Hello.class);

        hello.hello();

        context.close();
    }
}
