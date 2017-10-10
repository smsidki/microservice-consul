package com.greenfoarfece.ms.rating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greenfoarfece.ms.rating.dto.BookDto;
import com.greenfoarfece.ms.rating.model.Rating;
import com.greenfoarfece.ms.rating.service.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingServiceImpl implements RatingService {
	
	private static final String NA = "N/A";
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaultRating")
	@Override
	public Rating getRating(String isbn) {
		Rating rating = null;
		BookDto book = restTemplate.getForObject("http://book-service/books/{isbn}", BookDto.class, isbn);
		if (book.getIsbn().equalsIgnoreCase(NA)) {
			rating = defaultRating(null);
		} else {
			rating = new Rating();
			rating.setId(1L);
			rating.setIsbn(book.getIsbn());
			rating.setBookTitle(book.getTitle());
			rating.setStars(5);
		}
		return rating;
	}
	
	private Rating defaultRating(String bookIsbn) {
		Rating rating = new Rating();
		rating.setId(0L);
		rating.setIsbn(NA);
		rating.setBookTitle(NA);
		rating.setStars(0);
		return rating;
	}

}
