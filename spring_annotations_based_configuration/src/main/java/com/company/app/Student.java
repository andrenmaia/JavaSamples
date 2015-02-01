package com.company.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by caio on 2/1/15.
 */
public class Student {
    private Integer age;
    private String name;
    private String fathersName;

    @Required
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Autowired(required = false)
    public String getFathersName() {
        return fathersName;
    }
    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nAge:" + this.age + "\nFather's name:" + this.fathersName;
    }


}