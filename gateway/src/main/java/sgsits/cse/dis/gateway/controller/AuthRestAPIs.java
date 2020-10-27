package sgsits.cse.dis.gateway.controller;

import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.mail.util.MailConnectException;

import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.gateway.message.request.LoginForm;
import sgsits.cse.dis.gateway.message.request.SignUpForm;
import sgsits.cse.dis.gateway.message.response.JwtResponse;
import sgsits.cse.dis.gateway.message.response.ResponseMessage;
import sgsits.cse.dis.gateway.message.response.StaffFacultyInfo;
import sgsits.cse.dis.gateway.serviceImpl.UserDetailsServiceImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dis")
public class AuthRestAPIs {

	@Autowired
	private UserDetailsServiceImpl UserDetails;

	@ApiOperation(value="Sign in", response= JwtResponse.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path = "/signin", produces = "application/json")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) throws NotFoundException {
		return UserDetails.authenticateUser(loginRequest);
	}

	@ApiOperation(value="Sign Up", response= ResponseMessage.class, httpMethod = "POST", produces="application/json")
	@PostMapping("/signup")
	public ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody SignUpForm signUpRequest, HttpServletRequest request,Errors error) throws SQLException, MailConnectException, UnknownHostException {
//		if (error.hasErrors())
//			throw 
		return UserDetails.registerUser(signUpRequest, request);
	}

	@ApiOperation(value="pre activation", response= ResponseMessage.class, httpMethod = "POST", produces="application/json")
	@RequestMapping(value = "/preActivation", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> preActivation(@RequestParam("email") String recepientemail, HttpServletRequest request) throws MailConnectException, UnknownHostException {
		return UserDetails.preActivation(recepientemail, request);
	}

	@ApiOperation(value="activation", response= ModelAndView.class, httpMethod = "GET", produces="application/json")
	@RequestMapping(value = "/activation", method = RequestMethod.GET)
	public ModelAndView activateAccount(@RequestParam("token") String token) throws ParseException {
		return UserDetails.activateAccount(token);
	}

	@ApiOperation(value="Forget password", response= ResponseMessage.class, httpMethod = "POST", produces="application/json")
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> forgotPassword(@RequestParam("email") String recepientemail, HttpServletRequest request) throws MailConnectException, UnknownHostException {
		return UserDetails.forgotPassword(recepientemail,request);
	}

	@ApiOperation(value="Reset password", response= ModelAndView.class, httpMethod = "GET", produces="application/json")
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(@RequestParam("resetToken") String token) throws ParseException {
		return UserDetails.displayResetPasswordPage(token);
	}

	@ApiOperation(value="processing reset password", response= ResponseMessage.class, httpMethod = "POST", produces="application/json")
	@RequestMapping(value = "/processResetPassword", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> setNewPassword(@RequestBody Map<String, String> requestParams, RedirectAttributes redir, HttpServletResponse response) {
		return UserDetails.setNewPassword(requestParams, redir, response);
	}

	@ApiOperation(value="Get user type", response= String.class, httpMethod = "GET", produces="application/json")
	@GetMapping("/getUserType")
	public String getuserType(HttpServletRequest request) {
		return UserDetails.getuserType(request);
	}
	
	@ApiOperation(value="Get staff and faculty list", response= String.class, httpMethod = "GET", produces="application/json")
	@GetMapping("/getStaffFacultyList")
	public List<StaffFacultyInfo> getStaffFacultyInfo(HttpServletRequest request) {
		return UserDetails.getList();
	}


}