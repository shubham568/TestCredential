package com.digitalcredential.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.digitalcredential.entity.User;
import com.digitalcredential.service.UserService;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {	
	/*
	User Services
	*/	
	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	@Autowired
	private UserService userService;	
	 @Autowired
	    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {	      
	      this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	      this.userService = userService;	     
	    }	
	// Return registration form template
		@RequestMapping(value="/register", method = RequestMethod.GET)
		public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
			modelAndView.addObject("user", user);
			modelAndView.setViewName("register");
			return modelAndView;
		}
	 
		// Process form input data
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
			// Lookup user in database by e-mail
			User userExists = userService.findByEmail(user.getEmail_Id());
			
			System.out.println(userExists);
			
			if (userExists != null) {
				modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
				modelAndView.setViewName("register");
				bindingResult.reject("email");
			}
				
			if (bindingResult.hasErrors()) { 
				modelAndView.setViewName("register");		
			} else { // new user so we create user and send confirmation e-mail
						
				// Disable user until they click on confirmation link in email
			    user.setEnabled(false);
			      
			    // Generate random 36-character string token for confirmation link
			    user.setConfirmation_Token(UUID.randomUUID().toString());
			        
			    userService.saveUser(user);
					
				String appUrl = request.getScheme() + "://" + request.getServerName();
				
				SimpleMailMessage registrationEmail = new SimpleMailMessage();
				registrationEmail.setTo(user.getEmail_Id());
				registrationEmail.setSubject("Registration Confirmation");
				registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
						+ appUrl + "/confirm?token=" + user.getConfirmation_Token());
				registrationEmail.setFrom("noreply@domain.com");
				
				userService.sendEmail(registrationEmail);
				
				modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail_Id());
				modelAndView.setViewName("register");
			}
				
			return modelAndView;
		}
		
		// Process confirmation link
		@RequestMapping(value="/confirm", method = RequestMethod.GET)
		public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
				
			User user = userService.findByConfirmationToken(token);
				
			if (user == null) { // No token found in DB
				modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
			} else { // Token found
				modelAndView.addObject("confirmationToken", user.getConfirmation_Token());
			}
				
			modelAndView.setViewName("confirm");
			return modelAndView;		
		}
		
		// Process confirmation link
		@RequestMapping(value="/confirm", method = RequestMethod.POST)
		public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String,String> requestParams, RedirectAttributes redir) {
					
			modelAndView.setViewName("confirm");
			
			Zxcvbn passwordCheck = new Zxcvbn();
			
			Strength strength = passwordCheck.measure((requestParams.get("password")));
			
			if (strength.getScore() < 3) {
				bindingResult.reject("password");
				
				redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

				modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
				System.out.println(requestParams.get("token"));
				return modelAndView;
			}
		
			// Find the user associated with the reset token
			User user = userService.findByConfirmationToken(requestParams.get("token"));

			// Set new password
			user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

			// Set user to enabled
			user.setEnabled(true);
			
			// Save user
			userService.saveUser(user);
			
			modelAndView.addObject("successMessage", "Your password has been set!");
			return modelAndView;		
		}
		
	@GetMapping("user")
	public ResponseEntity<User> getUserById(@RequestParam("id") String id) {
		User user = userService.getUserById(Integer.parseInt(id));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("all-users")	
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@PostMapping("user")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		boolean flag = userService.addUser(user);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user?id={id}").buildAndExpand(user.getUser_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@DeleteMapping("user")
	public ResponseEntity<Void> deleteUser(@RequestParam("id") String id) {
		userService.deleteUser(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
/*-------------------------------------------End User Services----------------------------------------------------*/
}

