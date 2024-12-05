package com.job.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.Company;
import com.job.model.Job;
import com.job.repository.CompanyRepository;
import com.job.repository.JobRepository;
import com.job.service.CompanyService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Service
public class CompanyServiceIMPL implements CompanyService{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CompanyRepository companyRepository;
	;
	
	@Override
	public Company getCompanyById(Long id)throws Exception{
		return  companyRepository.findById(id).orElseThrow(()-> new Exception("Company not found !!"));
		
	}

	@Override
	public Company addCompany(Company company) {
		if(company.getJobs() != null) {
			for(Job job: company.getJobs()) {
				job.setCompany(company);
			}
		}
		return  companyRepository.save(company);
	}


	@Override
	public List<Company> getAllCompanies() {

		return companyRepository.findAll();
	}

	@Override
	public Company updateCompany(Company company , Long id)throws Exception {
		Company existedCompany = companyRepository.findById(id).orElseThrow(()-> new Exception("This company not found"));
		
		existedCompany.setName(company.getName());
		existedCompany.setDescription(company.getDescription());
		existedCompany.setJobs(company.getJobs());
		
		return companyRepository.save(existedCompany);
		
	}
	@Transactional
	@Override
	public boolean deleteCompany(Long id)throws Exception {
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

	

}
