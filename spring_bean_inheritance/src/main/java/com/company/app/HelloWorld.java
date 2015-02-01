package com.company.app;

/**
 * Created by caio on 2/1/15.
 */
public class HelloWorld {
    private String message1;
    private String message2;


    public void getMessage1() {
        System.out.println("World message 1:" + this.message1);
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void getMessage2() {
        System.out.println("World message 2:" + this.message2);
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
}
