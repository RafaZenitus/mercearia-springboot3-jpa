package com.merceariaweb.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merceariaweb.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Feanor", "feanor@email.com", "(55) 55555 - 5555", "123456" );
		return ResponseEntity.ok().body(u);
		
		
	}
}
 