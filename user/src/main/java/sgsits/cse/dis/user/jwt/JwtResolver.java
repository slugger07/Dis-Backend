package sgsits.cse.dis.user.jwt;

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
	public static String getUsernameFromAuthHead(final String authHeader){
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return Jwts.parser().setSigningKey("jwtDisSecretKey")
                    .parseClaimsJws(authHeader.replace("Bearer ", ""))
                    .getBody().getSubject();
        }
        return null;
    }
}