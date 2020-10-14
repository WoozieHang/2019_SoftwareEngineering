package com.example.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springweb.dao.HelloUser;

@Controller
public class ThymeleafController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/thymeleaf")
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello!");
        //System.out.println("/n/n/n/n/n!!!//n/n/n/nn"+list.get(0).getName());
        model.addAttribute("hi", helloService.getUserList().get(0).getName());

        return "hello";
    }

}
