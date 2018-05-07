package com.guomn.toolbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthychkController {
    @GetMapping("/healthchk")
    public String helloworld() {
        return "helloworld";
    }

}
