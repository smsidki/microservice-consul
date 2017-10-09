package com.greenfoarfece.ms.book.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.greenfoarfece.ms.book.model.Book;

/**
 * {@link Book} repository.
 * 
 * @author Sayid.Sidqi
 */
public interface BookRepository extends CrudRepository<Book, Long> {
	
	Optional<Book> findByIsbn(String isbn);

}
