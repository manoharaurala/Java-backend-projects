package com.example.Rubyspringbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    //to resturn static files html pages,jsp
    //to render page at backend

    @ResponseBody  //to resturn text,json,
    @GetMapping("/menu")
    public String getMenu(){
        return "menu.html";
    }
}
