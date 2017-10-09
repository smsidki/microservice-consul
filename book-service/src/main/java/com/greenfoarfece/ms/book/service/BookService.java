package com.greenfoarfece.ms.book.service;

import com.greenfoarfece.ms.book.model.Book;

public interface BookService {
	
	Book getBook(String isbn);
	Book addBook(Book newBook);
	boolean updateBook(Book book);
	void deleteBook(String isbn);

}
