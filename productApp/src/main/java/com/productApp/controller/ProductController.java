package com.productApp.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.productApp.model.Product;
import com.productApp.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
@SessionAttributes("product")
public class ProductController {
	
	@Autowired
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@ModelAttribute("product")
	public Product getProduct() {
		return new Product();
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/list")
	public String viewProduct(Model model) {
		model.addAttribute("products", service.getAllProducts());
		return "product-list";
	}
	
	@GetMapping("/add")
	public String showAddForm() {
		return "product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, SessionStatus status) {
		
		if(result.hasErrors()) {
			return "product-form";
		}
		
		service.saveProduct(product);
		status.setComplete();
		return "redirect:/products/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		Product product = service.getProductById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
		
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		if(service.getProductById(id).isEmpty()) {
			throw new RuntimeException("Cannot Delete. Product Not Found");
		}
		
		service.deleteProduct(id);
		return "redirect:/products/list";
	}
	
	@GetMapping("/count")
	@ResponseBody
	public String getProductCount() {
		return "Total Products: "+service.getAllProducts().size();
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "error-page";
	}
	
}
