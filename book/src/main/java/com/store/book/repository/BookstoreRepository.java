package com.store.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.store.book.model.Book;

@Repository
public interface BookstoreRepository extends JpaRepository<Book, String>{

	@Query(value = "select * from book  where author = ?1",nativeQuery = true)
	public List<Book> findBooksByAuthor(String author);
}
