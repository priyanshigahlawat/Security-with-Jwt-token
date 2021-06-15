package com.example.studentsLog.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String id;
    private Long roll;
    private String name;
    private String password;
    private int age;
    private String college;
    private String stream;
}