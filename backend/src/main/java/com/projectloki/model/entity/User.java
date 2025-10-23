package com.projectloki.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "app_users")
@Data
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(
            name = "perfil_seq_gen",
            sequenceName = "perfil_seq_gen",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_seq_gen")
    private Long id;

    private String username;
    private String email;
    private String password;
    private String fullName;
    private String DNI;
    private String phoneNumber;
    private String address;
    private String nationality;
    private LocalDate upDate;

    // Constructor sin id

    public User(String username, String email, String password, String fullName, String DNI, String phoneNumber, String address, String nationality) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.DNI = DNI;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.nationality = nationality;
    }

//    public void setUpDate(LocalDate upDate) {
//        this.upDate = upDate;
//    }
}
