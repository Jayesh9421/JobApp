package com.job.service;

import java.util.List;

import com.job.model.Job;

public interface JobService {

	List<Job> findAll();
	void createJob(Job job ) throws Exception;
	Job getJobById(Long id) throws Exception;
	void deleteJobById(Long id) throws Exception;
	void updateJob(Job job, Long id) throws Exception;
	
}
