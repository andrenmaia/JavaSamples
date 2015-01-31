package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        HelloWorld helloWorld2 = (HelloWorld)context.getBean("helloWorld");


        System.out.println("Original message:" + helloWorld.getMessage());


        helloWorld2.setMessage("New message helloWorld!");
        System.out.println("Message changed.");

        // Check is if singleton and print messages.
        System.out.println("From helloWorld:" + helloWorld.getMessage());
        System.out.println("From helloWorld2:" + helloWorld2.getMessage());
        System.out.println("Is singleton:" + helloWorld.getMessage().equals(helloWorld2.getMessage()));
    }
}
