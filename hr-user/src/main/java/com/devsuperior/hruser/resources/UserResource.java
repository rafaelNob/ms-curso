package com.devsuperior.hruser.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;


@RefreshScope
@RestController
@RequestMapping("/users")
public class UserResource {
	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
	
	@Autowired
	private UserRepository rep;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(rep.findById(id).get());

	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(rep.findByEmail(email));

	}

}
