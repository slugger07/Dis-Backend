package sgsits.cse.dis.infrastructure.jwt;

import io.jsonwebtoken.Jwts;
public class JwtResolver {

	// @Value("${dis.app.jwtSecret}")
	private static final String jwtSecret = "jwtDisSecretKey";
	public String getUserNameFromJwtToken(String token) {
		token = getJwt(token);
		String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		return username;
	}
	

	public String getIdFromJwtToken(String token){
		token = getJwt(token);
		String id = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getId();
		//return Integer.parseInt(id);
		return id;
	}

	private String getJwt(String authHeader) {
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}
		return null;
	}
	
	public String getUserTypeFromJwtToken(String token) {
		token = getJwt(token);
		String type = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getAudience();
		return type;
    }
}