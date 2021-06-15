package com.example.studentsLog.service;

import com.example.studentsLog.entity.UserEntity;
import com.example.studentsLog.repository.UserRepository;
import com.example.studentsLog.request.OtpRequest;
import com.example.studentsLog.response.PortalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class OtpService {

    @Autowired
    UserRepository repo;

    public PortalResponse verifyOtp(@RequestBody OtpRequest req){
        PortalResponse portalResponse = new PortalResponse();
        Optional<UserEntity> userEntity1 = repo.findById(req.getId());
        String otp1 = userEntity1.get().getOtp();
        if(otp1.equals(req.getOtp())){
            portalResponse.setMsg("Login successful");
            portalResponse.setStatusCode("200");
        } else {
            portalResponse.setMsg("Invalid OTP");
            portalResponse.setStatusCode("202");
        }
        return portalResponse;
    }
}
