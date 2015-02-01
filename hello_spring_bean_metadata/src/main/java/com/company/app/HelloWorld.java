package com.company.app;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by caio on 1/31/15.
 */
public class HelloWorld implements InitializingBean, DisposableBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init()
    {
        System.out.println("Bean will init without interfaces.");
    }

    public void destroyCustom()
    {
        System.out.println("Bean will destroy now - without interfaces.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean will init.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean will destroy now.");
    }
}
