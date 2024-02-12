package com.pmp.springapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pmp.springapi.dto.HelloDto;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/")
    public HelloDto hello() {
        return new HelloDto("Welcome to Spring Boot Application");
    }
}
