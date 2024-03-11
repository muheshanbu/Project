package com.ford.demo.companyclient.controller;

import com.ford.demo.companyclient.dto.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CompanyService",url = "http://localhost:8081/CompanyService")
public interface CompanyClient {
    @RequestMapping(method = RequestMethod.GET,value = "/company/get-by-id/{id}")
    Company getCompanyById(@PathVariable("id")Integer id);
}
