package com.das.webui.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/product")
    public String viewProduct(@RequestParam("id") Integer id){
        return "product";
    }

    @GetMapping("/checkout")
    public String checkOut(@RequestParam("id") Integer id){
        return "checkout";
    }

}
