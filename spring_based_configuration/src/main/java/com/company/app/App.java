package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(HelloWorldConfig.class);
        context.refresh();

        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        System.out.println(helloWorld.getMessage());

        helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World based config.");
        System.out.println(helloWorld.getMessage());

        context.registerShutdownHook();
    }
}
