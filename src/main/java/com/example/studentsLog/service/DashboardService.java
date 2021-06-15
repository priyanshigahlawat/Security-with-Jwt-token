package com.example.studentsLog.service;

import com.example.studentsLog.entity.UserEntity;
import com.example.studentsLog.repository.UserRepository;
import com.example.studentsLog.request.DashboardRequest;
import com.example.studentsLog.response.PortalResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class DashboardService {

    @Autowired
    UserRepository repo;

    public PortalResponse dashboard(@RequestBody DashboardRequest req){
        PortalResponse portalResponse = new PortalResponse();
        Optional<UserEntity> userEntity1 = repo.findById(req.getId());

        if(userEntity1.get().getToken().equals(req.getToken())){
            portalResponse.setMsg("valid user");
            portalResponse.setStatusCode("200");
        } else {
            portalResponse.setMsg("invalid user");
            portalResponse.setStatusCode("202");
        }


        return portalResponse;
    }
}
