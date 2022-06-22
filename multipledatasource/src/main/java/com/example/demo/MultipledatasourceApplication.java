package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.BookRepository.BookRepository;
import com.example.demo.Model.Book.Book;
import com.example.demo.Model.User.User;
import com.example.demo.UserRepository.UserRepository;

@SpringBootApplication
public class MultipledatasourceApplication implements CommandLineRunner{
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MultipledatasourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		bookRepository.saveAll(Arrays.asList(new Book(101, "java"),
				new Book(102, "python"),
				new Book(103, "c")));
		
		userRepository.saveAll(Arrays.asList(new User(10, "sujatha"),
				new User(11, "karthik"),
				new User(10, "ramya")));
		
	}

}
