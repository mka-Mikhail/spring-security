package com.mka.springsecurity.controllers;

import com.mka.springsecurity.api.AuthRequest;
import com.mka.springsecurity.api.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthorizationController {
    @PostMapping("/auth")
    public AuthResponse authorize(@RequestBody AuthRequest request) {
        log.info("Auth request: [{}, {}]", request.getUsername(), request.getPassword());
        return new AuthResponse("token value");
    }
}
