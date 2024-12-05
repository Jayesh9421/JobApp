package com.job.service;

import java.util.List;

import com.job.model.Company;

public interface CompanyService {

	Company getCompanyById(Long id) throws Exception;
	Company addCompany(Company company);
	List<Company> getAllCompanies();
	Company updateCompany(Company company , Long id) throws Exception;
	boolean deleteCompany(Long id) throws Exception;
	
}
