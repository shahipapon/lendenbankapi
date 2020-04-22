package com.devignites.lendenbankapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class apiController {
    @GetMapping("/")
    public String test() {
        return "Oops you are missing something .... :( ";
    }

}
