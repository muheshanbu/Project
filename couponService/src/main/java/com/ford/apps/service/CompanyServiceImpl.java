package com.ford.apps.service;

import com.ford.apps.dto.CompanyDTO;
import com.ford.apps.entity.Company;
import com.ford.apps.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService{

    @Autowired
    ICompanyRepository companyRepository;
    @Override
    public Company addCompany(CompanyDTO companyDTO) {
        Company company=new Company();
        company.setCompanyName(companyDTO.getName());
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long company_id) {
        companyRepository.deleteById(company_id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long company_Id) {
        Optional<Company> company=companyRepository.findById(company_Id);
        return company.orElse(null);
    }

    @Override
    public Company getCompanyByName(String company_name) {
        return companyRepository.findByCompanyName(company_name);
    }
}
