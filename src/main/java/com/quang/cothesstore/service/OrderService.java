package com.quang.cothesstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.quang.cothesstore.entity.Order;

public interface OrderService {

	public void saveOrder(Order order);
	
	List<Order> getAllOrderByUser_Id(String id);

	Order findById(int id);

	List<Order> findAll();

	List<Order> findTop5RecentOrder();

	List<String> findTop5RecentCustomer();

	Page<Order> findAll(Pageable pageable);

	void deleteById(int id);

	List<Order> findAllByPayment_Method(String payment_Method);

	List<Order> findTop5OrderByPaymentMethod(String payment_method);
}