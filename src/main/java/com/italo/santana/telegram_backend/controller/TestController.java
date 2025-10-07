package com.italo.santana.telegram_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auth")
public class TestController {

    @GetMapping("/name")
    public List<String> listName(){
        return List.of(
                "Ítalo",
                "Kay",
                "Lunna",
                "Allany",
                "Gaby"
        );
    }
}
