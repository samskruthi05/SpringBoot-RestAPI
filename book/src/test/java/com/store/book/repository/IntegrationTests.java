package com.store.book.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.book.model.Book;
import com.store.book.service.BookstoreService;

@SpringBootTest
public class IntegrationTests {

    @Autowired
    private BookstoreRepository bookRepo1;

    @Autowired
    private BookstoreService bookstoreService1;

    @Test
    public void testSaveBook() {
        Book book = new Book("1", "Title", "Author", 9.66);
        Book savedBook = bookstoreService1.saveBook(book);
        assertNotNull(savedBook);
        assertEquals(book, savedBook);
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("2", "Title", "Author", 9.99);
        bookRepo1.save(book);
        Book retrievedBook = bookstoreService1.getBookById("1234");
        assertNotNull(retrievedBook);
        assertEquals(book, retrievedBook);
    }

    @Test
    public void testGetAllBooksByAuthor() {
        Book book1 = new Book("3", "Title", "Author1", 19.99);
        bookRepo1.save(book1);
        List<Book> booksByAuthor = bookstoreService1.getAllBooksByAuthor("Author1");
        assertNotNull(booksByAuthor);
        assertEquals(1, booksByAuthor.size());
        assertEquals(book1, booksByAuthor.get(0));
    }

    @Test
    public void testDeleteBookById() {
        Book book = new Book("4", "Title", "Author", 20.99);
        bookRepo1.save(book);
        String deletedBookId = bookstoreService1.deleteBookById("1234");
        assertNotNull(deletedBookId);
        assertEquals("1234", deletedBookId);
        assertFalse(bookRepo1.existsById("1234"));
    }

}