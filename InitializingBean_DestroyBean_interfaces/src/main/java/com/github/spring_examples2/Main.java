package com.github.spring_examples2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        HelloWorld obj = context.getBean("helloWorld", HelloWorld.class);
        obj.getMessage();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
