package com.eCommerce.user.controller;

import com.eCommerce.user.DTO.LoginRequestDTO;
import com.eCommerce.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eCommerce")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        String token = authService.authenticateAndGenerateToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(token);
    }
}