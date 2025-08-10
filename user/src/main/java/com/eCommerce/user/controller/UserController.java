package com.eCommerce.user.controller;

import com.eCommerce.user.DTO.UserRegistrationDTO;
import com.eCommerce.user.response.UserRegistrationResponse;
import com.eCommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eCommerce")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserRegistrationResponse registered = userService.registerUser(userRegistrationDTO);
        return new ResponseEntity<>(registered, HttpStatus.CREATED);
    }
}
