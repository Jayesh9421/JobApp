package com.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.job.model.Review;
import com.job.service.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {

		return new ResponseEntity<List<Review>>(reviewService.getAllReviews(companyId), HttpStatus.OK);
	}

	@PostMapping("/review")
	public ResponseEntity<String> addReviw(@PathVariable Long companyId, @RequestBody Review review) throws Exception {

		reviewService.addReview(companyId, review);
		
		return new ResponseEntity<String>("review Added to the copmapany !!" , HttpStatus.CREATED);
		
	}
	@GetMapping("/review/{reviewId}")
	public ResponseEntity<Review> getReviw(@PathVariable Long companyId , @PathVariable Long reviewId) throws Exception{
		
		Review review = reviewService.getReview(companyId, reviewId);
		
		
		return new ResponseEntity<Review>(review , HttpStatus.OK);
	}
	
	@PutMapping("/reviewId/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId  , @PathVariable Long reviewId , @RequestBody Review review) throws Exception{
		
		reviewService.updateReview(companyId, reviewId, review);
		
		return new ResponseEntity<String>("review updated Successfully !!" , HttpStatus.OK);
	}

}
