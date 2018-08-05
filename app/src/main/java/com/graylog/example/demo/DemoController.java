package com.graylog.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class DemoController {

    Logger log = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/info")
    public void info() {
        log.info("This is an info log!");
    }


    @RequestMapping("/warn")
    public void warn() {
        log.warn("This is a warning!");
    }

    @RequestMapping("/errorLog") // "/error" is already mapped as a default
    public void error() {
        log.info("This is an error log!");
    }

    @RequestMapping("/exception")
    public void exception() {
        try {
            Files.copy(Paths.get("foo"), Paths.get("bar"));
        } catch (IOException e) {
            log.error("A wild exception appeared!", e);
        }
    }

}
