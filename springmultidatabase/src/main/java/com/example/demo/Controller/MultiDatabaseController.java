package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.product.ProductRepository;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.product.Product;
import com.example.demo.repository.customer.CustomerRepository;

@RestController
public class MultiDatabaseController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/products")
	private List<Product> getProducts()
	{
		return productRepository.findAll();
	}
	
	@GetMapping("/customers")
	private List<Customer> getCustomers()
	{
		return customerRepository.findAll();
	}
}
