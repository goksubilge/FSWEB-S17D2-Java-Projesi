package com.workintech.sprintday2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {
    @GetMapping("/")
    public String control() {
        return "Bilge";
    }
}
