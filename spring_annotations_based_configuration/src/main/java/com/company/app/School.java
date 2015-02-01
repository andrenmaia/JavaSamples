package com.company.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by caio on 2/1/15.
 */
public class School {

    @Autowired
    @Qualifier("luke")
    private Student studentWithFather;
    private Student student;

    @Autowired
    public School(Student student) {
        this.student = student;

        this.student.setName(this.student.getName() + " - from school");
        this.student.setFathersName("The school don't know the father's name.");
    }

    public Student getMainStudent() {
        return this.student;
    }

    public Student getStudentWithFather() {
        return studentWithFather;
    }

    @PostConstruct
    public void init(){
        System.out.println("School init.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("School destroy");
    }
}
