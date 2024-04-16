package com.quang.cothesstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quang.cothesstore.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category getById(int id);

}
