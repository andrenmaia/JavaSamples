package com.company.app;

/**
 * Created by caio on 2/1/15.
 */
public class HelloWorld {

    private String message;

    public HelloWorld(){
        // Default message
        this.message = "This is the default message";
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init(){
        System.out.println("Init HelloWorld Bean.");
    }

    public void cleanup(){
        System.out.println("Destroy HelloWorld Bean.");
    }
}
