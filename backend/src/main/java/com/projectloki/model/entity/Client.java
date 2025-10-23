package com.projectloki.model.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Client extends User{
    public Client(String username, String email, String password, String fullName, String DNI, String phoneNumber, String address, String nationality) {
        super(username, email, password, fullName, DNI, phoneNumber, address, nationality);
    }


}
