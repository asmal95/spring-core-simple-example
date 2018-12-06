package edu.spring;

import edu.spring.annotation.Profiling;
import edu.spring.annotation.RandomInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Profiling
public class HelloWorld implements Hello {

    @RandomInt(min = 1, max = 5)
    private int repeat;

    @Autowired
    @Qualifier("message")
    private String message;

    @Override
    public void hello() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroyed");
    }
}
