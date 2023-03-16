package com.bjoernkw.sampleforpossiblecsrftokenbuginspringsecurity6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleRestController {

    @GetMapping
    public String get() {
        return "OK";
    }

    @PostMapping
    public String post() {
        return "OK";
    }
}
