package com.quang.cothesstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quang.cothesstore.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	List<Cart> findAllByUser_id(String user_id);
	void deleteById(int id);

	@Modifying
	@Query("DELETE FROM Cart c WHERE c.id = :id")
	void removeById(int id);
}
