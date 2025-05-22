package com.merceariaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merceariaweb.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
