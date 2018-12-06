package edu.spring.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomAnnotationBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            RandomInt randomInt = field.getAnnotation(RandomInt.class);
            if (randomInt != null) {
                int min = randomInt.min();
                int max = randomInt.max();
                Random secureRandom = new Random();
                int i = min + secureRandom.nextInt(max-min);
                field.setAccessible(true);
                try {
                    field.set(bean, i);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
