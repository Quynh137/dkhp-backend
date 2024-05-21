package com.example.dkhpbackend.dto.requests;

import lombok.Data;

@Data
public class RequestLogin {
     private String username;
     private String password;
}