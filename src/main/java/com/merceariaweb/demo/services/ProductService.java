package com.merceariaweb.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merceariaweb.demo.model.Product;
import com.merceariaweb.demo.repositories.ProductRepository;
import com.merceariaweb.demo.services.exception.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	public List<Product> findAll()
	{
		return repository.findAll();
	}
	
	public Product findById(Long id)
	{
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
	}
	

}
