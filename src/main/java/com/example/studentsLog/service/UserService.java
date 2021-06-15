package com.example.studentsLog.service;

import com.example.studentsLog.entity.UserEntity;
import com.example.studentsLog.repository.UserRepository;
import com.example.studentsLog.request.LoginRequest;
import com.example.studentsLog.request.MailRequest;
import com.example.studentsLog.request.RegisterRequest;
import com.example.studentsLog.response.PortalResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;



    public PortalResponse saveInfo(@RequestBody @Valid RegisterRequest req){
        PortalResponse portalResponse = new PortalResponse();
        Optional<UserEntity> userEntity1 = repo.findById(req.getId());
        if(userEntity1.isPresent()){
            portalResponse.setMsg("record already present");
            portalResponse.setStatusCode("202");
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setRoll(req.getRoll());
            userEntity.setName(req.getName());
            userEntity.setId(req.getId());
            userEntity.setPassword(req.getPassword());
            userEntity.setAge(req.getAge());
            userEntity.setCollege(req.getCollege());
            userEntity.setStream(req.getStream());
            repo.save(userEntity);
            portalResponse.setMsg("Record saved");
            portalResponse.setStatusCode("200");
        }
        return portalResponse;
    }

    public PortalResponse login(@RequestBody LoginRequest req){
        PortalResponse portalResponse = new PortalResponse();
        Optional<UserEntity> userEntity1 = repo.findById(req.getId());

        String str = "";
        String val = "1234567890";
        if(userEntity1.isPresent()){
            if(userEntity1.get().getPassword().equals(req.getPassword())){
                portalResponse.setMsg("login successfull");
                portalResponse.setStatusCode("200");
                for(int i = 0; i < 4; i++){
                    int z = (int)(Math.random() * val.length());
                    str = str + z;
                }
                String token= Jwts.builder()
                        .setId(req.getId())
                        .setSubject(req.getPassword())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis()+1000*36000))
                        .signWith(SignatureAlgorithm.HS256,str)
                        .compact();
                userEntity1.get().setToken(token);
                repo.save(userEntity1.get());
                portalResponse.setToken(token);
            } else {
                portalResponse.setMsg("password incorect!!");
                portalResponse.setStatusCode("202");
            }
        } else{
                portalResponse.setMsg("you need to register first");
                portalResponse.setStatusCode("202");
        }

        return portalResponse;
    }

    public List<UserEntity> fetch(){
        List<UserEntity> userEntity = repo.findAll();
        return userEntity;
    }


}
