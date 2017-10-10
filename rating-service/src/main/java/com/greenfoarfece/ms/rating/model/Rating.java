package com.greenfoarfece.ms.rating.model;

import lombok.Data;

@Data
public class Rating {
	
	private Long id;
	private String isbn;
	private String bookTitle;
	private int stars;

}
