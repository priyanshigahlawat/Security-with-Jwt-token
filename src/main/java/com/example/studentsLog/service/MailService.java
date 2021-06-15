package com.example.studentsLog.service;

import com.example.studentsLog.entity.UserEntity;
import com.example.studentsLog.repository.UserRepository;
import com.example.studentsLog.request.MailRequest;
import com.example.studentsLog.request.OtpRequest;
import com.example.studentsLog.response.PortalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class MailService {

    @Autowired
    UserRepository repo;

    @Autowired
    JavaMailSender javaMailSender;

    public PortalResponse sendMail(@RequestBody MailRequest req){

        Optional<UserEntity> userEntity1 = repo.findById(req.getId());
        PortalResponse portalResponse = new PortalResponse();

        if (userEntity1.isPresent()) {
            String otp = "";
            String val = "1234567890";
            for(int i = 0; i < 4; i++){
                int z = (int)(Math.random() * val.length());
                otp = otp + z;
            }

            userEntity1.get().setOtp(otp);
            repo.save(userEntity1.get());

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("gahlawatpriyanshi11@gmail.com");
            simpleMailMessage.setTo(req.getId());
            simpleMailMessage.setSubject("authenticate otp");
            simpleMailMessage.setText(otp);
            javaMailSender.send(simpleMailMessage);

            portalResponse.setMsg("Mail send");
            portalResponse.setStatusCode("200");
        } else {
            portalResponse.setMsg("You need to register First");
            portalResponse.setStatusCode("202");
        }

        return portalResponse;
    }
}
