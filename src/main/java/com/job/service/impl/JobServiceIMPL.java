package com.job.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.Company;
import com.job.model.Job;
import com.job.repository.CompanyRepository;
import com.job.repository.JobRepository;
import com.job.service.JobService;

@Service
public class JobServiceIMPL implements JobService {
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Job> findAll() {

		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) throws Exception {
	    // Check if the company object is present in the request
//		 if (job.getCompany() == null || Objects.isNull(job.getCompany().getId())) {
//		        throw new Exception("Company information is missing in the request.");
//		    }
//
//	    // Fetch the existing company from the database using the provided ID
//	    Long companyId = job.getCompany().getId();
//	    Company existingCompany = companyRepository.findById(companyId)
//	            .orElseThrow(() -> new Exception("Company with ID " + companyId + " not found."));
//
//	    // Set the existing company to the job object
//	    job.setCompany(existingCompany);

	    // Save the job to the database
	    jobRepository.save(job);
	} 


	@Override
	public Job getJobById(Long id)throws Exception {

	 	return jobRepository.findById(id).orElseThrow(()-> new Exception("This id is Not found"));
		
	}

	@Override
	public void deleteJobById(Long id) throws Exception {
		
		Job exitingId = getJobById(id);
	
		 jobRepository.deleteById(exitingId.getId());
	}

	@Override
	public void updateJob(Job job , Long id) throws Exception {
		Job existingjob = getJobById(id);
		
		existingjob.setTitle(job.getTitle());
		existingjob.setDescription(job.getDescription());
		existingjob.setLocation(job.getLocation());
		existingjob.setMinSalary(job.getMinSalary());
		existingjob.setMaxSalary(job.getMaxSalary());
		
		jobRepository.save(existingjob);
		
	}

}
