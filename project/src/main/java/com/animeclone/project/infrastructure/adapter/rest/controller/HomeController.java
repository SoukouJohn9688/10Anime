package com.animeclone.project.infrastructure.adapter.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class HomeController {

    @GetMapping("/home")
    public String homePage(){
        return "Hello Weaboos!!!";
    }

}
