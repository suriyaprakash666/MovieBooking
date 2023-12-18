package com.altimetrik.moviebooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
        @NotNull(message = "Enter valid user id")
        private Integer userId;

        @Column(name = "USER_NAME")
        @Size(min = 5, max = 50, message = "User name must be between 2 and 50 characters")
        private String userName;

        @Column(name = "USER_PHONE_NUMBER")
        @Digits(integer = 10, fraction = 0, message = "Phone number must be a numeric value with up to 10 digits")
        private Long userPhoneNumber;

        @Column(name = "USER_EMAIL")
        @Email(message = "Please provide valid email address")
        private String userEmail;

        @Column(name = "USER_PASSWORD")
        @Size(min = 8, message = "Password must be at least 8 characters")
        private String userPassword;

    }
