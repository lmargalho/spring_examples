package com.github.spring_examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        HelloWorld obj = context.getBean("helloWorld", HelloWorld.class);
        obj.getMessage();

        HelloWorld2 obj2 = context.getBean("helloWorld2", HelloWorld2.class);
        obj2.getMessage();

        ((ClassPathXmlApplicationContext) context).close();
    }

}
