package com.company.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.xml.ws.WebEndpoint;

/**
 * Created by caio on 2/1/15.
 */

@Configuration
public class HelloWorldConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    @Scope("prototype")
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
}
