package sgsits.cse.dis.user.utils;

import io.jsonwebtoken.Jwts;

public class JwtUtils {

    public static String getUsernameFromAuthHead(final String authHeader){
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return Jwts.parser().setSigningKey("jwtDisSecretKey")
                    .parseClaimsJws(authHeader.replace("Bearer ", ""))
                    .getBody().getSubject();
        }
        return null;
    }

}
