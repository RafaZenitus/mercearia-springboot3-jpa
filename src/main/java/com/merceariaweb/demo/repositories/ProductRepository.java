package com.merceariaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merceariaweb.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
