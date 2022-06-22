package com.example.demo.Model.Book;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Book {
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	

}
