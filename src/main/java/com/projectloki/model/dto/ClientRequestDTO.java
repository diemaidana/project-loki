package com.projectloki.model.dto;

import lombok.Data;

@Data
public class ClientRequestDTO {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String DNI;
    private String phoneNumber;
    private String address;
    private String nationality;
}
