package com.ford.demo.companyclient.controller;

import com.ford.demo.companyclient.dto.CompanyDTO;
import com.ford.demo.companyclient.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping("/create")
    public ResponseEntity<String> createCompanyEntity(@RequestBody CompanyDTO company){
        System.out.println("Request Recieved");
        return new ResponseEntity<String>(companyService.createCompany(company),HttpStatus.OK);
    }

}
