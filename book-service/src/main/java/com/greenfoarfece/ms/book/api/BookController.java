package com.greenfoarfece.ms.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfoarfece.ms.book.model.Book;
import com.greenfoarfece.ms.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/{isbn}")
	public Book getBookByIsbn(@PathVariable String isbn) {
		// ISBN 9781617292545
		return bookService.getBook(isbn);
	}

}
