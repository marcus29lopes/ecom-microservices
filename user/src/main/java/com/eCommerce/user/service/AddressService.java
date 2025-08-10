package com.eCommerce.user.service;

import com.eCommerce.user.model.Address;
import com.eCommerce.user.model.User;
import com.eCommerce.user.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    private UserService userService;
    @Autowired
    private AddressRepository addressRepository;


    public void saveAddress(Address address) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userService.findUserByEmail(email);

        address.setUser(user);
        addressRepository.save(address);
    }
}
