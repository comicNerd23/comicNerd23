package com.moulik.bookkeeper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moulik.bookkeeper.domain.UserDto;
import com.moulik.bookkeeper.service.UserService;
import com.moulik.bookkeeper.util.SecurityConstants;

@RestController
@RequestMapping(SecurityConstants.SIGN_UP_URL)
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping()
	public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.saveDto(userDto), HttpStatus.CREATED);
	}
}
