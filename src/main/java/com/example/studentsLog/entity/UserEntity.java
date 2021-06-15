package com.example.studentsLog.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "studentInfo")
public class UserEntity {
    @Id
    private String id;

    @Column
    private Long roll;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private int age;

    @Column
    private String college;

    @Column
    private String stream;

    @Column
    private String otp;

    @Column
    private String token;
}

