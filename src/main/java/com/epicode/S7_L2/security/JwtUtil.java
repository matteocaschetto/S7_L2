package com.epicode.S7_L2.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

        private static final String SECRET_KEY = "MatteoMadhiDavideEleonora";  //superKey

        private static final Long EXPIRATION_TIME = 86400000L;  // tempo di durata

        private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        public String generateToken(String username) {
                return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key, SignatureAlgorithm.HS256).compact();

        }

       /* public String extractUsername(String token) {
            return Jwts.builder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();

        }*/
}
