package com.quang.cothesstore.service;

import java.util.List;

import com.quang.cothesstore.entity.Order_Item;

public interface Order_ItemService {

	List<Order_Item> getAllByOrder_Id(int id);
	public void saveOrder_Item(Order_Item order_Item);
	void deleteById(int id);
}
