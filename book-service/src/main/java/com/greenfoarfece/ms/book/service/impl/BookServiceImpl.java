package com.greenfoarfece.ms.book.service.impl;

import java.time.Year;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfoarfece.ms.book.model.Book;
import com.greenfoarfece.ms.book.repo.BookRepository;
import com.greenfoarfece.ms.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private static final String NA = "N/A"; 
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book getBook(String isbn) {
		return bookRepo.findByIsbn(isbn).orElse(new Book(0L, NA, NA, Year.of(0), NA));
	}

	@Override
	public Book addBook(Book newBook) {
		return bookRepo.save(newBook);
	}

	@Override
	public boolean updateBook(Book book) {
		boolean result = false;
		Optional<Book> oldBook = bookRepo.findByIsbn(book.getIsbn());
		if (result = oldBook.isPresent()) {
			book.setId(oldBook.get().getId());
			bookRepo.save(book);
		}
		return result;
	}

	@Override
	public void deleteBook(String isbn) {
		Optional<Book> result = bookRepo.findByIsbn(isbn);
		if(result.isPresent()) {
			bookRepo.delete(result.get());
		}
	}

}
