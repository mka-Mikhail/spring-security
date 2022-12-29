package com.mka.springsecurity.controllers;

import com.mka.springsecurity.api.AuthRequest;
import com.mka.springsecurity.api.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class AuthorizationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public AuthResponse authorize(@RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);

            //  FIXME: Сгенерировать токен и отдать клиенту
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
        return new AuthResponse("token value");
    }
}
