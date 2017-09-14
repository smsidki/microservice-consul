package com.greenfoarfece.ms.book.model;

import java.time.Year;

import lombok.Data;

@Data
public class Book {
	
	private Long id;
	private String title;
	private String author;
	private Year year;
	private String isbn;

}
