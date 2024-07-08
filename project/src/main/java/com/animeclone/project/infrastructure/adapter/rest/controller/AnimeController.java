package com.animeclone.project.infrastructure.adapter.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    @GetMapping
    private String cargarLista(){
        return "Probandooooooooo";
    }


}
