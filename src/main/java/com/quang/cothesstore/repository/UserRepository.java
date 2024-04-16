package com.quang.cothesstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quang.cothesstore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	User findByEmail(String email);
	
	Optional<User> findById(String id);
	
	User findByIdAndRole(String id, String role);
	
	void deleteById(String id);
}