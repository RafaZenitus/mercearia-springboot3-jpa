package com.merceariaweb.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.merceariaweb.demo.entities.User;
import com.merceariaweb.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Feanor", "feanor@gmail.com", "955555555", "123456"); 
		User u2 = new User(null, "Fingolfin", "fingolfin@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
