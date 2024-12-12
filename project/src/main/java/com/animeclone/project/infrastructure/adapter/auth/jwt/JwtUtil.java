package com.animeclone.project.infrastructure.adapter.auth.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;


@Component
public class JwtUtil {

    @Value("${application.security.jwt.secret.key}")
    private String secretKey;
//    @Value("${application.security.jwt.expiration}")
    private static long EXPIRATION_TIME=1000*360;

    public String generateToken(String subject, Map<String, Object> claims) {
        System.out.println(secretKey);


        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,secretKey )
                .compact();
    }

    public static String generateTokenStatic(JwtUtil jwtUtil, String subject, Map<String, Object> claims) {
        return jwtUtil.generateToken(subject, claims);

    }


}

