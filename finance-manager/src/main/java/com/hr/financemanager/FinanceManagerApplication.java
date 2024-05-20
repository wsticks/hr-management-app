package com.hr.financemanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceManagerApplication {

    @Value("${email.cc1}")
    private String name;
    public static void main(String[] args) {
        SpringApplication.run(FinanceManagerApplication.class, args);
    }

}
