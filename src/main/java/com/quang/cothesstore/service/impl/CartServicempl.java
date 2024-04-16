package com.quang.cothesstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quang.cothesstore.entity.Cart;
import com.quang.cothesstore.repository.CartRepository;
import com.quang.cothesstore.service.CartService;

@Service
public class CartServicempl implements CartService{

	@Autowired
	CartRepository cartRepository;
	/**
	 *
	 */
	@Override
	public void deleteById(int id) {
		cartRepository.deleteById(id);
	}
	@Override
	public List<Cart> GetAllCartByUser_id(String user_id) {
		return cartRepository.findAllByUser_id(user_id);
	}
	@Override
	public void saveCart(Cart cart) {
		cartRepository.save(cart);
	}
}
