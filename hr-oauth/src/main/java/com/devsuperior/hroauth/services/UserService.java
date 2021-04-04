package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feingclient.UserFeingClient;

@Service
public class UserService implements UserDetailsService  {
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

@Autowired
private UserFeingClient client;	

public User findByEmail(String email) {
	User user =	client.findByEmail(email).getBody();
	if(user == null) {
		logger.error("EMAIL NÃO ENCONTRADO: " + email);
		throw new IllegalArgumentException("Email não encontrado");
	}
	logger.info("EMAIL ENCONTRADO: " + email);
	return user;
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user =	client.findByEmail(username).getBody();
	if(user == null) {
		logger.error("EMAIL NÃO ENCONTRADO: " + username);
		throw new IllegalArgumentException("Email não encontrado");
	}
	logger.info("EMAIL ENCONTRADO: " + username);
	return user;
}

}
