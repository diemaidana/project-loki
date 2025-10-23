package com.projectloki.model.dto;

import lombok.Data;

@Data
public class ClientResponseDTO {
    private String username;
    private String email;
    private String name;
    private String lastName;
    private String DNI;
    private String phoneNumber;
    private String address;
    private String nationality;
}
