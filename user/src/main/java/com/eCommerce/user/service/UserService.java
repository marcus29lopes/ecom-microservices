package com.eCommerce.user.service;

import com.eCommerce.user.DTO.UserRegistrationDTO;
import com.eCommerce.user.Utils.Role;
import com.eCommerce.user.model.User;
import com.eCommerce.user.repository.UserRepository;
import com.eCommerce.user.response.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public UserRegistrationResponse registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (userRepository.existsByUserEmail((userRegistrationDTO.getEmail()))) {
            throw new RuntimeException("Email ja cadastrado");
        }

        User newUser = User.builder()
                .userName(userRegistrationDTO.getUserName())
                .userEmail(userRegistrationDTO.getEmail())
                .userPassword(encoder.encode(userRegistrationDTO.getPassword()))
                .userRole(Role.CUSTOMER)
                .userCreatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        userRepository.save(newUser);

        return UserRegistrationResponse.builder()
                .email(newUser.getUserEmail())
                .userName(newUser.getUserName())
                .build();

    }


    public User findUserByEmail(String email) {

        return userRepository.findByUserEmail(email);
    }
}
