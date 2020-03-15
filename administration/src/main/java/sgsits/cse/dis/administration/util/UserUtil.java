package sgsits.cse.dis.administration.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.jwt.JwtResolver;

@Service
public class UserUtil {
	JwtResolver jwtResolver = new JwtResolver();
	
	public String getuserType(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return jwtResolver.getUserTypeFromJwtToken(authHeader.replace("Bearer ", ""));
        }
        return null;
    }
}
