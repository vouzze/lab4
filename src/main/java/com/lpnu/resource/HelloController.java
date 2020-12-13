package com.lpnu.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index(){
        return "Greetings from Spring Boot!";
    }
}
