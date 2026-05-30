package com.gabkings.learning_portal.jwtUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${spring.jwt.secret-key}")
    private String secretKey;

    private final Long expiration = 600000L;

    public String extractUsername(String token) {
        return getExtractClaims(token, Claims::getSubject);
    }



    private Date getExpiration(String token) {
        return getExtractClaims(token, Claims::getExpiration);
    }


    public boolean validateJwtExpiration(String token) {
        Date expiration = getExpiration(token);
        return !expiration.before(new Date());
    }


    public <T> T getExtractClaims(String jwt , Function<Claims, T> claimsExtractor) {
        Claims claims = getExtractClaims(jwt);
        return claimsExtractor.apply(claims);
    }

    private Claims getExtractClaims(String token) {
        return (Claims) Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parse(token)
                .getPayload();
    }


    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .issuer("learning_portal")
                .subject(userDetails.getUsername())
                .signWith(getSecretKey())
                .compact();
    }


    public SecretKey getSecretKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
