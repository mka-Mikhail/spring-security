package com.mka.springsecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtService {
    public String generateJwtToken(UserDetails userDetails) {
        return "token";
    }
}
