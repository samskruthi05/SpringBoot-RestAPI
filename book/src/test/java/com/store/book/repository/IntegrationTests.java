package com.store.book.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.book.model.Book;
import com.store.book.service.BookstoreService;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class IntegrationTests {

    @Mock
    private BookstoreRepository bookRepo1;

    @InjectMocks
    private BookstoreService bookstoreService1;

    @Before
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
//        this.mockMvc= MockMvcBuilders.standaloneSetup(bookController).build();
    }
    @Test
    public void testSaveBook() {
        Book book = new Book("1", "Title", "Author", 9.66);
        Mockito.when(bookRepo1.save(book)).thenReturn(book);
        Book savedBook = bookstoreService1.saveBook(book);
        assertNotNull(savedBook);
        assertEquals(book, savedBook);
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("2", "Title", "Author", 9.99);
        bookRepo1.save(book);
        Mockito.when(bookRepo1.getById("2")).thenReturn(book);
        Book retrievedBook = bookstoreService1.getBookById("2");
        assertNotNull(retrievedBook);
        assertEquals(book, retrievedBook);
    }

    @Test
    public void testGetAllBooksByAuthor() {
        Book book1 = new Book("3", "Title", "Author1", 19.99);
        List<Book> arr = new ArrayList<>(Arrays.asList(book1));
        Mockito.when(bookRepo1.findBooksByAuthor("3")).thenReturn(arr);
        List<Book> booksByAuthor = bookstoreService1.getAllBooksByAuthor("Author1");
        assertNotNull(booksByAuthor);
    }

    @Test
    public void testDeleteBookById() {
        Book book = new Book("4", "Title", "Author", 20.99);
        bookRepo1.save(book);
        Mockito.doNothing().when(bookRepo1).deleteById("4");
        String deletedBookId = bookstoreService1.deleteBookById("1234");
        assertNotNull(deletedBookId);
        assertEquals("1234", deletedBookId);
        assertFalse(bookRepo1.existsById("1234"));
    }

}