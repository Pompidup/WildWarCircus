package com.pompidup.WildWarCircus.security;

import com.pompidup.WildWarCircus.entities.User;
import com.pompidup.WildWarCircus.entities.UserDTO;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import com.pompidup.WildWarCircus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private CircusRepository circusRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		if (user.getPicture() != null) {
			newUser.setPicture(user.getPicture());
		}
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setMoney(2500);
		if (user.isBot() != null) {
			newUser.setBot(user.isBot());
		}
		if (user.getCircusId() != null) {
			newUser.setCircus(circusRepository.findById(user.getCircusId()).get());
		}
		return userDao.save(newUser);
	}
}
