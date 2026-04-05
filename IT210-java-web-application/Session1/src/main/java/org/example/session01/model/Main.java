package org.example.session01.model;

import org.example.session01.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SystemConfig systemConfig = context.getBean(SystemConfig.class);
        systemConfig.display();
    }
}
