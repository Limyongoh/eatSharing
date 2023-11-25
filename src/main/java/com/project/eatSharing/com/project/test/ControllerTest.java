package com.project.eatSharing.com.project.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ControllerTest {
    @GetMapping("/test")
    public String test(){
        return "controller test";
    }
}
