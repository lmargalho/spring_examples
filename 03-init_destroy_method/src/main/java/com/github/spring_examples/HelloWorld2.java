package com.github.spring_examples;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld2 {
    private String message;

    @PostConstruct
    public void init(){
        message = "Change HelloWorld 2";
        System.out.println("INIT:: HelloWorld2");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroy:: HelloWorld2");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }

}
