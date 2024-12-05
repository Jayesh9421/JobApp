package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.model.Job;
@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
