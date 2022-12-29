package com.mka.springsecurity.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtService {

    private String secret = "d;sfkbjhnfsdfb8dsfbdlkjn";  //секрет, который лучше всего держать где-то в другом месте
    private Long expireTimeMillis = 1000L * 60 * 5;

    public String generateJwtToken(UserDetails user) {
        String username = user.getUsername();
        List<String> authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        Map<String, Object> claims = new HashMap<>(Map.of("authority", authorities));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
