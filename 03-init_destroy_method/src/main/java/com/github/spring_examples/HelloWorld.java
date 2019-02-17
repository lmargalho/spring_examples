package com.github.spring_examples;

public class HelloWorld {
    private String message;

    public void init() {
        message = "Modified Hello World!";
        System.out.println("INIT:: HelloWorld");
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
