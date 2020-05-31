package sgsits.cse.dis.gateway.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.mail.util.MailConnectException;

import javassist.NotFoundException;
import sgsits.cse.dis.gateway.message.request.LoginForm;
import sgsits.cse.dis.gateway.message.request.SignUpForm;
import sgsits.cse.dis.gateway.message.response.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

@Component
public interface UserDetailsService {
    ResponseEntity<?> authenticateUser(LoginForm loginRequest) throws NotFoundException;
    ResponseEntity<ResponseMessage> registerUser(SignUpForm signUpRequest, HttpServletRequest request)  throws SQLException, MailConnectException, UnknownHostException;
    ResponseEntity<ResponseMessage> preActivation(String recepientemail, HttpServletRequest request) throws MailConnectException, UnknownHostException;
    ModelAndView activateAccount(String token) throws ParseException;
    ResponseEntity<ResponseMessage> forgotPassword(String recepientemail, HttpServletRequest request) throws MailConnectException, UnknownHostException;
    ModelAndView displayResetPasswordPage(String token) throws ParseException;
    ResponseEntity<ResponseMessage> setNewPassword(Map<String, String> requestParams, RedirectAttributes redir, HttpServletResponse response);
    String getuserType(HttpServletRequest request);
    //UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
