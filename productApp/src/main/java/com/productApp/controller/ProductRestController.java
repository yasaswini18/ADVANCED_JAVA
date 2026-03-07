package com.productApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productApp.model.Product;
import com.productApp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	@Autowired
	private final ProductService service;
	
	public ProductRestController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return service.getProductById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
	}
	
	@PostMapping
	public String addProduct(@RequestBody Product product) {
		service.saveProduct(product);
		return "Product Added Successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return "Product Deleted Successfully";
	}
}
