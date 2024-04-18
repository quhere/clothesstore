package com.quang.cothesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quang.cothesstore.entity.Cart;
import com.quang.cothesstore.entity.Category;
import com.quang.cothesstore.entity.Product;
import com.quang.cothesstore.entity.User;
import com.quang.cothesstore.repository.ProductRepository;
import com.quang.cothesstore.service.CartService;
import com.quang.cothesstore.service.CategoryService;
import com.quang.cothesstore.service.CookieService;
import com.quang.cothesstore.service.ProductService;
import com.quang.cothesstore.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductControler {
	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CartService cartService;

	@Autowired
	HttpSession session;

	@Autowired
	CookieService cookie;

	@GetMapping(value = { "", "/home" })
	public String listStudents(Model model) throws Exception {
		Cookie user_name = cookie.read("user_name");

		String NoSignIn = (String) session.getAttribute("NoSignIn");
		
		session.setAttribute("NoSignIn", null);
		String a = (String) session.getAttribute("NoSignIn");
		
		if (user_name != null) {
			User acc = userService.findByIdAndRole(user_name.getValue(), "user");
			if (acc == null)
				session.setAttribute("countCart", "0");
			else {
				session.setAttribute("acc", acc);
				session.setAttribute("AddToCartErr", null);
				List<Cart> listCart = cartService.GetAllCartByUser_id(acc.getId());
				session.setAttribute("countCart", listCart.size());
			}
		}

		model.addAttribute("NoSignIn", NoSignIn);

		List<Product> Top12ProductBestSellers = productService.findTop12ProductBestSellers();
		List<Product> Top12ProductNewArrivals = productService.findTop12ProductNewArrivals();
		model.addAttribute("Top12ProductBestSellers", Top12ProductBestSellers);
		model.addAttribute("Top12ProductNewArrivals", Top12ProductNewArrivals);
		return "index";
	}

	@GetMapping("/shop")
	public String shop(Model model) throws Exception {
		List<Product> lp = productService.getAllProduct();
		int TotalPro = lp.size();
		model.addAttribute("TotalPro", TotalPro);
		Pageable pageable = PageRequest.of(0, 12);
		Page<Product> page = productRepository.findAll(pageable);
		List<Category> listCategory = categoryService.findAll();
		String search_input = (String) session.getAttribute("search_input");
		model.addAttribute("listProduct", page);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("search_input", search_input);
		return "shop";
	}

	@GetMapping("/shop/{id}")
	public String shopPage(Model model, @PathVariable int id) throws Exception {
		List<Product> lp = productService.getAllProduct();
		int TotalPro = lp.size();
		model.addAttribute("TotalPro", TotalPro);
		Pageable pageable = PageRequest.of(id, 12);
		Page<Product> page = productRepository.findAll(pageable);
		model.addAttribute("listProduct", page);
		List<Category> listCategory = categoryService.findAll();
		String search_input = (String) session.getAttribute("search_input");
		User user = (User) session.getAttribute("acc");
		if (user != null) {
			model.addAttribute("user_Name", user.getUser_Name());
		}
		if (listCategory != null)
			model.addAttribute("listCategory", listCategory);
		else
			model.addAttribute("listCategory", null);
		model.addAttribute("search_input", search_input);
		return "shop";
	}

	@GetMapping("/productDetail/{id}")
	public String ProductDetailId(@PathVariable int id, Model model) {
		Product product = productService.getProductById(id);
		if (product != null) {
			List<Product> relatedProduct = productService.findTop4ProductByCategory_id(product.getCategory().getId());
			model.addAttribute("relatedProduct", relatedProduct);
			model.addAttribute(product);
			return "shop-details";
		} else {
			return "redirect:/home";
		}

	}

}
