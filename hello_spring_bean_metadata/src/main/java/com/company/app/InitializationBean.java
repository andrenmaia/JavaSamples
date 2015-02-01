package com.company.app;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by caio on 1/31/15.
 */
public class InitializationBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean initialized.");
    }
}
