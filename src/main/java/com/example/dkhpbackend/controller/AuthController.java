package com.example.dkhpbackend.controller;

import com.example.dkhpbackend.dto.reponses.JwtResponse;
import com.example.dkhpbackend.dto.requests.RequestLogin;
import com.example.dkhpbackend.security.jwt.JwtUtils;
import com.example.dkhpbackend.service.impl.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public JwtResponse authenticateUser(@RequestBody RequestLogin loginRequest) {

        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate the JWT token
        String jwt = jwtUtils.generateToken(authentication);

        // Return the JWT token in the response
        return new JwtResponse(jwt);
    }
}
