package com.eCommerce.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressResponse {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;



}
