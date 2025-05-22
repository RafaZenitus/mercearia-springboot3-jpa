package com.merceariaweb.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merceariaweb.demo.model.Category;
import com.merceariaweb.demo.repositories.CategoryRepository;
import com.merceariaweb.demo.services.exception.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll()
	{
		return repository.findAll();
	}
	
	public Category findById(Long id)
	{
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
	}
	

}
