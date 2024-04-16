package com.quang.cothesstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quang.cothesstore.entity.Category;
import com.quang.cothesstore.repository.CategoryRepository;
import com.quang.cothesstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	 CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(Category category) {
		return null;
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.getById(id);
	}

	@Override
	public Category updateCategory(Category category) {
		return null;
	}
	
	@Override
	public void deleteCategoryId(int id) {
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
