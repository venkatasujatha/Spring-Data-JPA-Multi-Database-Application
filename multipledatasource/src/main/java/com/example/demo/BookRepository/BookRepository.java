package com.example.demo.BookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Book.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
