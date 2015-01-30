package com.company.app;

import java.lang.Override;
import java.lang.String;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ToImplemente i = new ToImplemente() {
            @Override
            public String getDummyMessage() {
                return "This is a dummy message.";
            }
        };

        System.out.println( "Hello World!" );
        System.out.println(i.getDummyMessage());
    }
}

interface ToImplemente
{
    String getDummyMessage();
}