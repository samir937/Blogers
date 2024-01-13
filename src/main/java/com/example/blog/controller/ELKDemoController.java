package com.example.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ELKDemoController {


    @PostMapping("/echo")
    public String printLogs(){
        log.info("Inside the log print controller :{}","Successfully");
        return "Successfully";
    }
}
