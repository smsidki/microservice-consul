package com.greenfoarfece.ms.rating.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greenfoarfece.ms.rating.dto.BookDto;
import com.greenfoarfece.ms.rating.model.Rating;
import com.greenfoarfece.ms.rating.service.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingServiceImpl implements RatingService {

	@HystrixCommand(fallbackMethod = "defaultRating")
	@Override
	public Rating getRating(String bookIsbn) {
		BookDto book = new RestTemplate().getForObject("http://localhost:8079/book-api/books/{bookIsbn}", BookDto.class, bookIsbn);
		Rating rating = new Rating();
		rating.setId(1L);
		rating.setBookId(book.getId());
		rating.setStars(5);
		return rating;
	}
	
	protected Rating defaultRating(String bookIsbn) {
		Rating rating = new Rating();
		rating.setBookId(0L);
		rating.setId(0L);
		rating.setStars(0);
		return rating;
	}

}
