package com.example.studentsLog.response;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class PortalResponse {
    private String msg;
    private String statusCode;
    private String token;
}
