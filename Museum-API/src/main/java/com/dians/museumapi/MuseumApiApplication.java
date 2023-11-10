package com.dians.museumapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MuseumApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuseumApiApplication.class, args);
    }

}
