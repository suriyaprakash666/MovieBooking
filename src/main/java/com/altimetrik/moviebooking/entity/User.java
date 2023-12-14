package com.altimetrik.moviebooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PHONE_NUMBER")
    private Long userPhoneNumber;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

}
