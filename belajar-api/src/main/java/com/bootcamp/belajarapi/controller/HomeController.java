package com.bootcamp.belajarapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
    @GetMapping
    public String index(){
        return "welcome to rest api";
    }
}
