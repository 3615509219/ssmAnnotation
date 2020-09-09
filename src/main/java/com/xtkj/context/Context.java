package com.xtkj.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum Context {
    INSTALL;
    public ClassPathXmlApplicationContext context(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        return context;
    }
}

