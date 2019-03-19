package com.github.spring_examples2;

import java.util.Set;

public class HelloWorld {
    private String message;
    private Set lst;

    public HelloWorld(HelloWorld helloWorld) {
        //this.message = message;
    }


    public HelloWorld(String message) {
        this.message = message;
    }

    public Set getLst() {
        return lst;
    }

    public void setLst(Set lst) {
        this.lst = lst;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }

}
