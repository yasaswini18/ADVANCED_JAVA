package com.BookSecurity.Security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
	@Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;
    
    public JwtUtil()
    {
    	
    }
    
    private Key getSigningKey()
    {
    	return Keys.hmacShaKeyFor(secret.getBytes());
    }
    
    //generate jwt token using username and role
    public String generateToken(String username,String role) {
		return Jwts.builder().subject(username)
				.claim("role", role)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(getSigningKey())
				.compact();
		
	}
    
    private Claims getClaims(String token)
    {
    	return  Jwts.parser()
    			    .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
    			    .build()
    			    .parseSignedClaims(token)
    			    .getPayload();
    }
    
    //Extract username for token
    public String extractUsername(String token)
    {
    	return getClaims(token).getSubject();
    }
    
    //Extract role from token
    public String extractRole(String token)
    {
    	return getClaims(token).get("role",String.class);
    }
    
    //validate token signature and expiration
    public boolean validateToken(String token)
    {
    	try {
    		getClaims(token);
    		return true;
    	}catch(JwtException e)
    	{
    		return false;
    	}
    }
}
