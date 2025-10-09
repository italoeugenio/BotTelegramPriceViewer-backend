package com.italo.santana.telegram_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/owner")
    public List<String> listOwner(){
        return List.of(
                "Dono"
        );
    }

    @GetMapping("/employer")
    public List<String> listEmployer (){
        return List.of(
                "Funcionário"
        );
    }
}
