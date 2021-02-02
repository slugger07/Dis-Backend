package sgsits.cse.dis.academics.jwt;

import io.jsonwebtoken.Jwts;
/**
 * <h1><b>JwtResolver</b> class.</h1>
 * <p>This class contains implementation helper functions to decode JwtToekn.
 * @author Devyani Garg.
 * @version 1.0.
 * @since 8-OCT-2018.
 */
public class JwtResolver {

	// @Value("${dis.app.jwtSecret}")
	private static final String jwtSecret = "jwtDisSecretKey";

	/**
	 * Get username from jwt token.
	 * @param token
	 * @return username
	 */
	public String getUserNameFromJwtToken(String token) {
		token = getJwt(token);
		String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		return username;
	}
	
	/**
	 * get userId from jwt token.
	 * @param token
	 * @return userId
	 */
	public String getIdFromJwtToken(String token){
		token = getJwt(token);
		String id = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getId();
//		return Integer.parseInt(id);
		return id;
	}

	/**
	 * helper function get jwt from http's Authentication heade.
	 * @param authHeader.
	 * @return token.
	 */
	private String getJwt(String authHeader) {
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}
		return null;
	}
}