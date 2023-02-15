package com.store.book.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.book.model.Book;
import com.store.book.repository.BookstoreRepository;

@Service
@Transactional
public class BookstoreService {
	
	@Autowired
	BookstoreRepository bookRepo;

	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book getBookById(String id) {
		return bookRepo.getById(id);
	}
	
	public List<Book> getAllBooksByAuthor(String author) {
		return bookRepo.findBooksByAuthor(author);
	}
	
	public String deleteBookById(String id) {
		 
		bookRepo.deleteById(id);
		return id;
	}
}
