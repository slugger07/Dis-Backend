package sgsits.cse.dis.gateway.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sgsits.cse.dis.gateway.message.request.LoginForm;
import sgsits.cse.dis.gateway.message.request.SignUpForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;


public interface UserDetailsService {
    ResponseEntity<?> authenticateUser(LoginForm loginRequest);
    ResponseEntity<?> registerUser(SignUpForm signUpRequest, HttpServletRequest request)  throws SQLException;
    ResponseEntity<?> preActivation(String recepientemail, HttpServletRequest request);
    ModelAndView activateAccount(String token) throws ParseException;
    ResponseEntity<?> forgotPassword(String recepientemail, HttpServletRequest request);
    ModelAndView displayResetPasswordPage(String token) throws ParseException;
    ResponseEntity<?> setNewPassword(Map<String, String> requestParams, RedirectAttributes redir, HttpServletResponse response);
    String getuserType(HttpServletRequest request);
    //UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
