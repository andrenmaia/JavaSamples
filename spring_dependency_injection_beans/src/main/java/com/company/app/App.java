package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        TextEditor textEditor = (TextEditor)context.getBean("textEditor");
        textEditor.spellCheck();
        textEditor.applySpecialEffect();

    }
}
