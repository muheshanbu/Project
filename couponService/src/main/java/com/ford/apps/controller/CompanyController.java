package com.ford.apps.controller;

import com.ford.apps.entity.Company;
import com.ford.apps.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/company")
public class CompanyController {
    @Autowired
    CompanyServiceImpl companyService;

    @PostMapping("/create")
    ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<Company>(companyService.addCompany(company), HttpStatus.OK);
    }
}
