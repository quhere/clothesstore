package com.quang.cothesstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quang.cothesstore.entity.Product;
import com.quang.cothesstore.repository.ProductRepository;
import com.quang.cothesstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById( id);
	}

	@Override
	public List<Product> findByProduct_NameContaining(String name) {
		return productRepository.findByProduct_NameContaining(name);
	}

	@Override
	public List<Product> findTop12ProductBestSellers() {
		return productRepository.findTop12ProductBestSellers();
	}

	@Override
	public List<Product> findTop12ProductNewArrivals() {
		return productRepository.findTop12ProductNewArrivals();
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Page<Product> findByProduct_NameAndCategory_idContaining(String name, int category_id, Pageable pageable) {
		return productRepository.findByProduct_NameAndCategory_idContaining(name, category_id, pageable);
	}

	@Override
	public Page<Product> findByProduct_NameContaining(String name, Pageable pageable) {
		return productRepository.findByProduct_NameContaining(name, pageable);
	}

	@Override
	public List<Product> findTop4ProductByCategory_id(int id) {
		return productRepository.findTop4ProductByCategory_id(id);
	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	
}