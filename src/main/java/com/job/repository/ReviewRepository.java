package com.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByCompanyId(Long companyId);

}
