package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepo;

	public void save(Book b) {
		bookrepo.save(b);
	}

	public List<Book> getAllBook() {
		return bookrepo.findAll();

	}

	public Book getBookById(int id) {
		return bookrepo.findById(id).get();
	}

}
