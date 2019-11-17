package com.das.webui.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainRouter {
    @GetMapping("/")
    public String homepage(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
