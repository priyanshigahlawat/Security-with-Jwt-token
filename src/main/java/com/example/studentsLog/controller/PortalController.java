package com.example.studentsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PortalController {
    @GetMapping("/login3")
    public String displayLogin(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String displayRegister(){
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/login2")
    public String displayLogin2() {
        return "login2";
    }
}
