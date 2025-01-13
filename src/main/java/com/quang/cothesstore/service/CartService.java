package com.quang.cothesstore.service;

import java.util.List;

import com.quang.cothesstore.entity.Cart;
import org.springframework.stereotype.Service;

public interface CartService {
	void deleteById(int id);

	List<Cart> GetAllCartByUser_id(String user_id);

	void saveCart(Cart cart);
}
