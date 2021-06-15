package com.example.studentsLog.request;

import lombok.Data;

import javax.xml.soap.SAAJResult;

@Data
public class DashboardRequest {
    private String id;
    private String token;
}
