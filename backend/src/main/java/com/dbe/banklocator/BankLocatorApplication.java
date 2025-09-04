package com.dbe.banklocator;  // Root package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dbe.banklocator")
public class BankLocatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankLocatorApplication.class, args);
    }
}