package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloContoller {

    @GetMapping("/hello-world")
    public String sayHello() {
        return "Hello_world";
    }
}
