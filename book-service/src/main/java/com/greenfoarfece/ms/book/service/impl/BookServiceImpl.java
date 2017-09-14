package com.greenfoarfece.ms.book.service.impl;

import java.time.Year;

import org.springframework.stereotype.Service;

import com.greenfoarfece.ms.book.model.Book;
import com.greenfoarfece.ms.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book getBook(String isbn) {
		Book book = new Book();
		book.setId(1L);
		book.setAuthor("Craig Walls");
		book.setIsbn(isbn);
		book.setTitle("Spring Boot in Action");
		book.setYear(Year.of(2016));
		return book;
	}

}
