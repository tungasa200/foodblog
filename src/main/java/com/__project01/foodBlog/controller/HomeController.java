package com.__project01.foodBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

//    @GetMapping("/comment/list")
//    public String guestbook(){
//        return "guestBook";
//    }

}
