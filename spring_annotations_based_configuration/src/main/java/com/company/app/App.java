package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Student s = (Student)context.getBean("student");
        System.out.println(s.toString());

        School school = (School)context.getBean("school");

        Student main = school.getMainStudent();
        System.out.println(main.toString());

        Student withFather = school.getStudentWithFather();
        System.out.println(withFather.toString());


        context.registerShutdownHook();
    }
}
