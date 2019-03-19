package com.github.spring_examples2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean, DisposableBean {
    private String message;

    public void afterPropertiesSet() {
        System.out.println("After Properties:: HelloWorld");
        message = "Change HelloWorld value!";
    }

    public void destroy() {
        System.out.println("Destroy:: HelloWorld");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }

}
