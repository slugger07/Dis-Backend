package sgsits.cse.dis.user.jwt;

import io.jsonwebtoken.Jwts;

public class JwtResolver {

	private static final String jwtSecret = "jwtDisSecretKey";

	public String getUserNameFromJwtToken(String token) {
		token = getJwt(token);
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public String getIdFromJwtToken(String token){
		token = getJwt(token);
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getId();
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