package com.example.studentsLog.controller;

import com.example.studentsLog.entity.UserEntity;
import com.example.studentsLog.request.*;
import com.example.studentsLog.response.OtpResponse;
import com.example.studentsLog.response.PortalResponse;
import com.example.studentsLog.service.DashboardService;
import com.example.studentsLog.service.MailService;
import com.example.studentsLog.service.OtpService;
import com.example.studentsLog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    MailService mailService;

    @Autowired
    OtpService otpService;

    @Autowired
    DashboardService dashboardService;

    @PostMapping("/saveInfo")
    public PortalResponse saveInfo(@RequestBody @Valid RegisterRequest req){
        return service.saveInfo(req);
    }

    @PostMapping("/login")
    public PortalResponse login(@RequestBody LoginRequest req){
        return service.login(req);
    }

    @GetMapping("/fetchAllRecords")
    public List<UserEntity> fetch(){
        return service.fetch();
    }

    @PostMapping("/sendMail")
    public PortalResponse sendMail(@RequestBody MailRequest req){
        return mailService.sendMail(req);
    }

    @PostMapping("/verifyOtp")
    public PortalResponse verify(@RequestBody OtpRequest req) {
        return otpService.verifyOtp(req);
    }

    @PostMapping("/dashboard1")
    public PortalResponse dashboard(@RequestBody DashboardRequest req){
        return dashboardService.dashboard(req);
    }
}
