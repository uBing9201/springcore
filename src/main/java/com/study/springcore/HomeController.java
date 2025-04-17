package com.study.springcore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println("HomeController 생성됨!! 내가 한거 아님");
    }

    @GetMapping("/hello")
    public String home() {
        System.out.println("서버요청 들어옴");
        return "home";
    }

}
