package com.merceariaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merceariaweb.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
