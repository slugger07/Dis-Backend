package sgsits.cse.dis.gateway.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgsits.cse.dis.gateway.message.request.LoginForm;
import sgsits.cse.dis.gateway.message.request.SignUpForm;
import sgsits.cse.dis.gateway.message.response.JwtResponse;
import sgsits.cse.dis.gateway.message.response.ResponseMessage;
import sgsits.cse.dis.gateway.model.User;
import sgsits.cse.dis.gateway.repo.TaskRepository;
import sgsits.cse.dis.gateway.repo.UserRepository;
import sgsits.cse.dis.gateway.security.jwt.JwtProvider;
import sgsits.cse.dis.gateway.service.UserPrinciple;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dis")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
		return ResponseEntity.ok(new JwtResponse(jwt, userPrincipal.getUsername(), userPrincipal.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByMobileNo(signUpRequest.getMobileNo())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Mobile Number is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),signUpRequest.getDob(),signUpRequest.getMobileNo(),
				encoder.encode(signUpRequest.getPassword()));

		user.setCreatedBy(signUpRequest.getUsername());
		//user.setCreatedDate();
		//user.setUserType("student");
		
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	@GetMapping("/getUserType")
	public String getuserType(HttpServletRequest request)
	{
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return jwtProvider.getUserTypeFromJwtToken(authHeader.replace("Bearer ", ""));
		}
		return null;
	}
}