package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BookRepository.BookRepository;
import com.example.demo.Model.Book.Book;
import com.example.demo.Model.User.User;
import com.example.demo.UserRepository.UserRepository;

@RestController
public class MultiDatabaseController1 {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getUsers(User user)
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(Book book)
	{
		return bookRepository.findAll();
	}
	
}
