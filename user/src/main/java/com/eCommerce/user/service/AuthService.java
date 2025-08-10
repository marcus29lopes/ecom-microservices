package com.eCommerce.user.service;

import com.eCommerce.user.Utils.JwtUtils;
import com.eCommerce.user.exceptions.InvalidCredentialsException;
import com.eCommerce.user.repository.UserRepository;
import com.eCommerce.user.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder encoder;

    public String authenticateAndGenerateToken(String email, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return jwtUtils.generateJwtToken(userDetails.getUsername());

        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Credenciais inválidas");
        }
    }
}
