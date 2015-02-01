package com.company.app;

/**
 * Created by caio on 2/1/15.
 */
public class HelloWorld {
    private String message;

    public void  getMessage() {
        System.out.println("Your message:" + this.message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("Bean is going through init.");
    }

    public void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
