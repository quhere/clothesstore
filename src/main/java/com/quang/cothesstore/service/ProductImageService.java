package com.quang.cothesstore.service;

import com.quang.cothesstore.entity.ProductImage;

public interface ProductImageService {

	void save(ProductImage productImage);

	void deleteById(int id);

}
