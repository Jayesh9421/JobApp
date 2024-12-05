package com.job.service;

import java.util.List;

import com.job.model.Review;

public interface ReviewService {

	List<Review> getAllReviews(Long companyId); 
	void addReview(Long companyId , Review review) throws Exception;
	Review getReview(Long companyId , Long reviewId) throws Exception;
	Review updateReview(Long companyId , Long reviewId , Review review) throws Exception;
}
