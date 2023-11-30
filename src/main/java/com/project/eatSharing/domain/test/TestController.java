package com.project.eatSharing.domain.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String one (){
        return "test controller 1";
    }

    @GetMapping("/2")
    public String two (){
        return "test controller 2";
    }
}
