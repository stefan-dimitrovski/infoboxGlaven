package com.project.infobox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class InfoboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoboxApplication.class, args);
    }

}
