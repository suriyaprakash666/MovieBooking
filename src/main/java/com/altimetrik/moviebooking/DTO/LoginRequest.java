package com.altimetrik.moviebooking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
    private Integer userID;
    private String userEmail;
    private String userPassword;

}