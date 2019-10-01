package sgsits.cse.dis.academics.jwt;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;

public class JwtResolver {

	// @Value("${dis.app.jwtSecret}")
	private static final String jwtSecret = "jwtDisSecretKey";

	public String getUserNameFromJwtToken(String token) {
		token = getJwt(token);
		String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		return username;
	}
	
	public long getIdFromJwtToken(String token){
		token = getJwt(token);
		String id = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getId();
		return Integer.parseInt(id);
	}

	private String getJwt(String authHeader) {
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}
		return null;
	}
}