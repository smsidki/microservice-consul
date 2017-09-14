package com.greenfoarfece.ms.rating.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfoarfece.ms.rating.model.Rating;
import com.greenfoarfece.ms.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/{isbn}")
	public Rating getRatingByBookIsbn(@PathVariable String isbn) {
		return ratingService.getRating(isbn);
	}

}
