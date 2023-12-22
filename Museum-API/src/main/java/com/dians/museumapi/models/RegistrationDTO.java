package com.dians.museumapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegistrationDTO {

    private String username;

    private String password;

}
