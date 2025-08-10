package com.eCommerce.user.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegistrationResponse {

    String userName;
    String email;
}
