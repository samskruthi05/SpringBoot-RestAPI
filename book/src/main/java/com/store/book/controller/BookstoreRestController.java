package com.store.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.book.model.Book;
import com.store.book.service.BookstoreService;

@RestController
@RequestMapping("/book")
public class BookstoreRestController {

	@Autowired
	BookstoreService bookService;

	@PostMapping(path = "/savebook", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book saveBook(@RequestBody Book book) {

		return bookService.saveBook(book);
	}

	@GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBookById(@PathVariable("id") String id) {

		return bookService.getBookById(id);
	}

	@GetMapping(path = "/getbyAuthor/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getBookByAuthor(@PathVariable("author") String author) {

		return bookService.getAllBooksByAuthor(author);
	}

	@PutMapping(path = "/updatebook", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBookDetails(@RequestBody Book book) {

		return bookService.saveBook(book);
	}
	
	@DeleteMapping(path = "/deletebook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateBookDetails(@PathVariable("id") String id) {

		 bookService.deleteBookById(id);
		 return "Deleted Book with id "+id;
	}
}
