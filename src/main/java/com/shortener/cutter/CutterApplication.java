package com.shortener.cutter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CutterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CutterApplication.class, args);
    }

}
