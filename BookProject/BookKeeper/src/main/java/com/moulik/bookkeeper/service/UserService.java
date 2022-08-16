package com.moulik.bookkeeper.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moulik.bookkeeper.domain.User;
import com.moulik.bookkeeper.domain.UserDto;
import com.moulik.bookkeeper.repository.UserRepository;

@Service
public class UserService {
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserRepository userRepository;
	
	public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
	}
	
	@Transactional(rollbackFor = Exception.class) 
	public String saveDto(UserDto userDto) { 
	    userDto.setPassword(bCryptPasswordEncoder
	           .encode(userDto.getPassword()));
	    User user = new User();
	    user.setUsername(userDto.getUsername());
	    user.setPassword(userDto.getPassword());
	    user.setFirstName(userDto.getFirstName());
	    user.setLastName(userDto.getLastName());
	    user.setEmail(userDto.getEmail());
	    return Long.toString(userRepository.save(user).getId());
	}


}
