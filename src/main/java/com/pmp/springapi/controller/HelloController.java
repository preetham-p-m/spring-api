package com.pmp.springapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pmp.springapi.dto.HelloDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@PropertySource(value = "myproperties.properties", ignoreResourceNotFound = true)
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${welcome.message.from.custom.file}")
    private String welcomeMessageFromCustomFile;

    @GetMapping("/v1")
    public HelloDto helloOne() {
        return new HelloDto(welcomeMessage);
    }

    @GetMapping("/v2")
    public HelloDto helloTwo() {
        return new HelloDto(welcomeMessageFromCustomFile);
    }
}
