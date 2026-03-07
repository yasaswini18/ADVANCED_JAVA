package com.arcana.BookStoreRestApi.config;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	private final String SECRET_KEY = "ERTYUILJHGFDSAZXCVBNMKYTRESWDFVSZWSRFFCESDD";
	
	private final int JWT_EXPIRATION=900000;
	private final int REFRESH_EXPIRATION=604800000;
	
	private SecretKey getSigningKey()
	{
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		
		return Keys.hmacShaKeyFor(keyBytes);
	}
	public String generateRefreshToken(String email) {
		return generateToken(email,JWT_EXPIRATION);
	}
	public String genertaeRefreshToken(String email) {
		return generateToken(email,REFRESH_EXPIRATION);
	}
	
	public String generateToken(String email,long expiration) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(getSigningKey(),SignatureAlgorithm.HS256)
				.compact();
	}
}
