package com.siat.testspring.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCtrl {
    @RequestMapping("/")
    public String index() {
        System.out.println("index Controller landing");
        return "landing" ;
    }
    
}
