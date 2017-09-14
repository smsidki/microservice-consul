package com.greenfoarfece.ms.rating.service.impl;

import org.springframework.stereotype.Service;

import com.greenfoarfece.ms.rating.model.Rating;
import com.greenfoarfece.ms.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Override
	public Rating getRating(String bookIsbn) {
		Rating rating = new Rating();
		rating.setBookId(1L);
		rating.setId(1L);
		rating.setStars(5);
		return rating;
	}

}
