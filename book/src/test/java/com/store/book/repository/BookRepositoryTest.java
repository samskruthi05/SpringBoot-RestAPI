package com.store.book.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.store.book.controller.BookstoreRestController;
import com.store.book.model.Book;



@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest
{
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	
	@Mock
	private BookstoreRepository bookRepository;
	
	@InjectMocks
	private BookstoreRestController bookController;
	
	Book RECORD_1 = new Book("1","sam","author1", 9.55);
	Book RECORD_2 = new Book("2","jack","author1", 19.55);
	Book RECORD_3 = new Book("3","jill","author1", 39.55);


	@Before
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(bookController).build();
	}
	
	@Test
	public void getById_success() throws Exception
	{
		Mockito.when(bookRepository.findById("1")).thenReturn(java.util.Optional.of(RECORD_1));
		bookController.getBookById("1");
		
	}
	
	
}