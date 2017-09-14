package com.greenfoarfece.ms.rating.model;

import lombok.Data;

@Data
public class Rating {
	
	private Long id;
	private Long bookId;
	private int stars;

}
