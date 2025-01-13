package com.quang.cothesstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quang.cothesstore.entity.Cart;
import com.quang.cothesstore.repository.CartRepository;
import com.quang.cothesstore.service.CartService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	/**
	 *
	 */
	@Override
	@Transactional
	public void deleteById(int id) {
		System.out.println("Attempting to delete cart with ID: " + id);
		if (cartRepository.existsById(id)) {
			try {
//				cartRepository.deleteById(id);
				cartRepository.removeById(id);
				System.out.println("Cart with ID " + id + " deleted successfully.");
			} catch (Exception e) {
				System.err.println("Error while deleting cart with ID: " + id);
				e.printStackTrace();
			}
		} else {
			System.out.println("Cart with ID " + id + " does not exist.");
		}
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
