package com.mka.springsecurity.api;

import lombok.Getter;

@Getter
public class AuthRequest {
    private String username;
    private String password;
}
