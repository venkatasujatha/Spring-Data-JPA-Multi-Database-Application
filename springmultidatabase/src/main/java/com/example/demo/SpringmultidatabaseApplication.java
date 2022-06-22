package com.example.demo;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.product.ProductRepository;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.product.Product;
import com.example.demo.repository.customer.CustomerRepository;

@SpringBootApplication
public class SpringmultidatabaseApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmultidatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.saveAll(Arrays.asList(new Product(1, "p1", "pen"),
				new Product(2, "p2", "book"),
				new Product(3, "p3", "phone")));
		
	
		customerRepository.saveAll(Arrays.asList(new Customer(23,"sam", "sam@gmail.com"),
				new Customer(24,"sasi", "sasi@gmail.com"),
				new Customer(25,"prashanth", "chinnu@gmail.com")));
	}

}
