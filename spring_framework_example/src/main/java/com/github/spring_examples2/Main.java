package com.github.spring_examples2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

public class Main {


    @Bean
    public HelloWorld myBean(){
        return new HelloWorld("message");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        HelloWorld obj = context.getBean("helloWorld", HelloWorld.class);
        obj.getMessage();
        //for( Object v : obj.getLst())
       //     System.out.println(v);
    }
}
