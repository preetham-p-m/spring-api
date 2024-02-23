package com.pmp.springapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pmp.springapi.dto.HelloDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/health")
    public HelloDto helloOne() {
        return new HelloDto(welcomeMessage);
    }
}
