package com.eCommerce.user.controller;

import com.eCommerce.user.model.Address;
import com.eCommerce.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eCommerce")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/address/save")
    public void addAddress(@RequestBody Address address) {

        addressService.saveAddress(address);

    }
}
