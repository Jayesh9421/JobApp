package com.job.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.Company;
import com.job.model.Review;
import com.job.repository.ReviewRepository;
import com.job.service.CompanyService;
import com.job.service.ReviewService;

@Service
public class ReviewServiceIMPL implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private CompanyService companyService;

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public void addReview(Long companyId, Review review) throws Exception {

		Company company = companyService.getCompanyById(companyId);

		if (company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
		}
	}

	@Override
	public Review getReview(Long companyId, Long reviewId) throws Exception {
		Company company = companyService.getCompanyById(reviewId);
		if (company != null) {

			return reviewRepository.findById(reviewId).orElseThrow(() -> new Exception("Review not found !!"));
		}

		return null;
	}

	@Override
	public Review updateReview(Long companyId, Long reviewId, Review review) throws Exception {
		Company company = companyService.getCompanyById(reviewId);

		if (company == null) {
			throw new Exception("company not found with IDD : " + companyId);
		}

		Review existingReview = getReview(companyId, reviewId);

		if (existingReview == null) {
			throw new Exception("Review not found in this ID " + reviewId);
		}

		existingReview.setTitle(review.getTitle());
		existingReview.setDescription(review.getDescription());
		existingReview.setRating(review.getRating());
		existingReview.setCompany(company);
		return reviewRepository.save(existingReview);

	}

}
