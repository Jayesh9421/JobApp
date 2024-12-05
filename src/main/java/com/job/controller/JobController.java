package com.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.job.model.Job;
import com.job.service.JobService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobService.findAll();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping("/job")
    public ResponseEntity<String> createJob(@RequestBody Job job) throws Exception {
        jobService.createJob(job);
//        job.getCompany();
        return new ResponseEntity<>("Job created successfully!", HttpStatus.CREATED);
    }


    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) throws Exception {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) throws Exception {
         jobService.deleteJobById(id);
		return new ResponseEntity<String>("id delete Successfully !!" , HttpStatus.OK);
      
    }
    
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable Long id, @RequestBody Job job) throws Exception {
    	 jobService.updateJob(job, id);
    	
        return new ResponseEntity<>("job updated Successfully !! " , HttpStatus.CREATED);
    }
}
