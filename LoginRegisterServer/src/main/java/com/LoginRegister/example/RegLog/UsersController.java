package com.LoginRegister.example.RegLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser") 
	@CrossOrigin(origins = "http://localhost:4200")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}
	
	@PostMapping("/loginUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Boolean loginUser(@RequestBody LoginRequest loginRequest) {
		return userService.loginUser(loginRequest);
		
   }

}
