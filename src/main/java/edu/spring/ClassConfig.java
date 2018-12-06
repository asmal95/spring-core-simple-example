package edu.spring;

import edu.spring.annotation.ProfilingAnnotationBeanPostProcessor;
import edu.spring.annotation.RandomAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ClassConfig {

    @Bean
    public String message() {
        return "Hello from class";
    }

    @Bean
    @Scope("singleton")
    public HelloWorld helloService(@Autowired String message) {
        return new HelloWorld();
    }

    @Bean
    public ContextClosedHandler handler() {
        return new ContextClosedHandler();
    }

    @Bean
    public ProfilingAnnotationBeanPostProcessor profilingAnnotationBeanPostProcessor() {
        return new ProfilingAnnotationBeanPostProcessor();
    }

    @Bean
    RandomAnnotationBeanPostProcessor randomAnnotationBeanPostProcessor() {
        return new RandomAnnotationBeanPostProcessor();
    }

}
