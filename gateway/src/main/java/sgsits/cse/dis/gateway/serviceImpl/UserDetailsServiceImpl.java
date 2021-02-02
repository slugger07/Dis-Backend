package sgsits.cse.dis.gateway.serviceImpl;

import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.mail.util.MailConnectException;

import javassist.NotFoundException;
import sgsits.cse.dis.gateway.constants.GlobalURI;
import sgsits.cse.dis.gateway.controller.EmailController;
import sgsits.cse.dis.gateway.feignClient.UserClient;
import sgsits.cse.dis.gateway.message.request.LoginForm;
import sgsits.cse.dis.gateway.message.request.SignUpForm;
import sgsits.cse.dis.gateway.message.response.JwtResponse;
import sgsits.cse.dis.gateway.message.response.ResponseMessage;
import sgsits.cse.dis.gateway.message.response.StaffFacultyInfo;
import sgsits.cse.dis.gateway.model.User;
import sgsits.cse.dis.gateway.repo.TaskRepository;
import sgsits.cse.dis.gateway.repo.UserRepository;
import sgsits.cse.dis.gateway.security.jwt.JwtProvider;
import sgsits.cse.dis.gateway.service.UserDetailsService;
import sgsits.cse.dis.gateway.service.UserPrinciple;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

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
	@Autowired
    EmailController email;
	@Autowired
    UserClient userClient;

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userRepository.findByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
//
//        return UserPrinciple.build(user);
//    }

    @Override
    public ResponseEntity<?> authenticateUser(LoginForm loginRequest) throws NotFoundException{
        Optional<User> u = userRepository.findByUsername(loginRequest.getUsername());
		if(u.isPresent() == false)
			throw new NotFoundException("username not found");
		
        if (u.get().isEnabled()) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateJwtToken(authentication);
            UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
            // Update Last Login
            Optional<User> user = userRepository.findByUsername(userPrincipal.getUsername());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            user.get().setLastLogin(simpleDateFormat.format(new Date()));
            userRepository.save(user.get());
            return ResponseEntity.ok(new JwtResponse(jwt, userPrincipal.getUsername(), userPrincipal.getAuthorities()));
        } else
            return new ResponseEntity<>(new ResponseMessage("Your Account is not yet activated! Please activate first."), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ResponseMessage> registerUser(SignUpForm signUpRequest, HttpServletRequest request) throws SQLException, MailConnectException, UnknownHostException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByMobileNo(signUpRequest.getMobileNo())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Mobile Number is already in use!"), HttpStatus.BAD_REQUEST);
        }

        if (userClient.findUser(signUpRequest)) { // separate message for incorrect detail
            User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getDob(),
                    signUpRequest.getMobileNo(), encoder.encode(signUpRequest.getPassword()));
            user.setCreatedBy(signUpRequest.getUsername());
            user.setCreatedDate(simpleDateFormat.format(new Date()));
            user.setUserType(userClient.findUserType(signUpRequest));
            user.setActivationToken(UUID.randomUUID().toString());
            user.setActivationTokenExpiry(simpleDateFormat.format(DateUtils.addDays(new Date(), 3)));
            //userRepository.save(user);
            userClient.updateUserIdByEmail(userRepository.save(user).getId(), signUpRequest.getEmail());
            String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();
            // Email message
            email.sendSimpleEmail(user.getEmail(), "DIS Account Activation Request", "To activate your account, click the link below:\n" + appUrl + "/dis/activation?token="+ user.getActivationToken());
            return new ResponseEntity<>(new ResponseMessage("Registration successfull! An email has been sent to your registered email address. Please verify to continue!"), HttpStatus.OK);
        } else
            return new ResponseEntity<>(new ResponseMessage("You are not registered with the System! Please contact administration."), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ResponseMessage> preActivation(String recepientemail, HttpServletRequest request) throws MailConnectException, UnknownHostException {
        Optional<User> userlist = userRepository.findByEmail(recepientemail);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (userlist.isPresent()) {
            User u = userlist.get();
            if(u.isEnabled()) {
                return new ResponseEntity<>(new ResponseMessage("Your account is already activated!"), HttpStatus.BAD_REQUEST);
            }
            else {
                u.setActivationToken(UUID.randomUUID().toString());
                u.setActivationTokenExpiry(simpleDateFormat.format(DateUtils.addDays(new Date(), 3)));
                u.setModifiedBy(u.getId());
                u.setModifiedDate(simpleDateFormat.format(new Date()));
                userRepository.save(u);
                String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();
                // Email message
                email.sendSimpleEmail(u.getEmail(), "DIS Account Activation Request", "To activate your account, click the link below:\n" + appUrl + "/dis/activation?token=" + u.getActivationToken());
                return new ResponseEntity<>(new ResponseMessage("An Account Activation link has been sent to registered email address!"), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ResponseMessage("We didn't find an account for this e-mail address!"), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ModelAndView activateAccount(String token) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Optional<User> user = userRepository.findUserByActivationToken(token);
        System.out.println("user "+ user.isPresent());
        ModelAndView modelAndView = new ModelAndView();
        if (user.isPresent()) { // Token found in DB
            if (simpleDateFormat.parse(user.get().getActivationTokenExpiry()).after(new Date())) {
                user.get().setEnabled(true);
                user.get().setActivationToken(null);
                user.get().setActivationTokenExpiry(null);
                user.get().setModifiedBy(user.get().getId());
                user.get().setModifiedDate(simpleDateFormat.format(new Date()));
                if (userClient.updateEmailAndUserId(user.get().getMobileNo())) {
                    userRepository.save(user.get());
                    modelAndView.addObject("token", token);
                    modelAndView.setViewName("redirect:"+GlobalURI.DIS_FRONTEND);
                }
            } else {
                modelAndView.addObject("errorMessage", "Oops!  Your account activation link has expired.");
                modelAndView.setViewName("redirect:"+GlobalURI.DIS_FRONTEND+"/activate-account");
            }
        } else { // Token not found in DB
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid account activation link.");
            modelAndView.setViewName("redirect:"+GlobalURI.DIS_FRONTEND+"/activate-account");
        }
        return modelAndView;
    }

    @Override
    public ResponseEntity<ResponseMessage> forgotPassword(String recepientemail, HttpServletRequest request) throws MailConnectException, UnknownHostException {
        Optional<User> userlist = userRepository.findByEmail(recepientemail);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (userlist.isPresent()) {
            User u = userlist.get();
            u.setResetToken(UUID.randomUUID().toString());
            u.setResetTokenExpiry(simpleDateFormat.format(DateUtils.addDays(new Date(), 1)));
            u.setModifiedBy(u.getId());
            u.setModifiedDate(simpleDateFormat.format(new Date()));
            userRepository.save(u);
            String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();

            // Email message
            email.sendSimpleEmail(u.getEmail(), "DIS Password Reset Request",
                    "To reset your password, click the link below:\n" + appUrl + "/dis/resetPassword?resetToken="
                            + u.getResetToken());
            return new ResponseEntity<>(
                    new ResponseMessage("A password reset link has been sent to registered email address!"),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseMessage("We didn't find an account for this e-mail address!"),
                HttpStatus.BAD_REQUEST);
    }

    // Display form to reset password
    @Override
    public ModelAndView displayResetPasswordPage(String token) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Optional<User> user = userRepository.findUserByResetToken(token);
        ModelAndView modelAndView = new ModelAndView();
        if (user.isPresent()) { // Token found in DB
            if (simpleDateFormat.parse(user.get().getResetTokenExpiry()).after(new Date())) {
                modelAndView.addObject("resetToken", token);
                modelAndView.setViewName("redirect:"+GlobalURI.DIS_FRONTEND+"/reset-password");
            } else {
                modelAndView.addObject("errorMessage", "Oops!  Your password reset link has expired.");
                modelAndView.setViewName("redirect:"+GlobalURI.DIS_FRONTEND+"/forgot-password");
            }
        } else { // Token not found in DB
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
            modelAndView.setViewName("redirect:"+GlobalURI.DIS_FRONTEND+"/forgot-password");
        }
        return modelAndView;

    }

    // Process reset password form
    @Override
    public ResponseEntity<ResponseMessage> setNewPassword(Map<String, String> requestParams, RedirectAttributes redir, HttpServletResponse response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // Find the user associated with the reset token
        System.out.println(requestParams.get("resetToken"));
        System.out.println(requestParams.get("password"));
        Optional<User> user = userRepository.findUserByResetToken(requestParams.get("resetToken"));
        ModelAndView modelAndView = new ModelAndView();
        // This should always be non-null but we check just in case
        if (user.isPresent()) {
            User resetUser = user.get();
            // Set new password
            resetUser.setPassword(encoder.encode(requestParams.get("password")));
            // Set the reset token to null so it cannot be used again
            resetUser.setResetToken(null);
            resetUser.setResetTokenExpiry(null);
            // Update modified date
            resetUser.setModifiedBy(resetUser.getId());
            resetUser.setModifiedDate(simpleDateFormat.format(new Date()));
            // Save user
            userRepository.save(resetUser);
            // In order to set a model attribute on a redirect, we must use RedirectAttributes
            // redir.addFlashAttribute("successMessage", "You have successfully reset your password. You may now login.");
            //modelAndView.addObject("successMessage", "You have successfully reset your password. You may now login.");
            //modelAndView.setViewName("redirect:http://localhost:4200");
            return new ResponseEntity<>(new ResponseMessage("You have successfully reset your password. You may now login."),
                    HttpStatus.OK);
            //return modelAndView;
        } else {
            //modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
            //modelAndView.setViewName("redirect:http://localhost:4200/forgot-password");
            return new ResponseEntity<>(new ResponseMessage("Oops!  This is an invalid password reset link."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public String getuserType(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return jwtProvider.getUserTypeFromJwtToken(authHeader.replace("Bearer ", ""));
        }
        return null;
    }

	public List<StaffFacultyInfo> getList() {
		List<StaffFacultyInfo> list = new ArrayList<>();
		List<User> staff = userRepository.findByUserType("staff");
		List<User> faculty = userRepository.findByUserType("faculty");
		for(User user : staff) {
			StaffFacultyInfo c= new StaffFacultyInfo();
			c.setId(user.getId());
			c.setType(user.getUserType());
			c.setUserName(user.getUsername());
			
			list.add(c);
		}
		for(User user : faculty) {
			StaffFacultyInfo c= new StaffFacultyInfo();
			c.setId(user.getId());
			c.setType(user.getUserType());
			c.setUserName(user.getUsername());
			
			list.add(c);
		}
		return list;
	}
}