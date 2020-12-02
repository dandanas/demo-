package com.dandan;

import com.dandan.config.MainConfigOfAutowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        AnnotationConfigApplicationContext applicationContexts = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    }

}
