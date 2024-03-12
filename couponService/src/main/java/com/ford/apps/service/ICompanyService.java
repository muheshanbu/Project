package com.ford.apps.service;

import com.ford.apps.CouponManagementSystemApplication;
import com.ford.apps.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICompanyService {

    public Company addCompany(Company company);

    public void deleteCompany(Long company_id);

    public List<Company> getAllCompanies();

    public Company getCompanyById(Long company_Id);

    public Company getCompanyByName(String company_name);

    //public Company issueCouponsToCompany(Long company_id, Integer numberOfCoupons);
}
