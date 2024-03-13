package com.ford.demo.companyclient.controller;

import com.ford.demo.companyclient.dto.CouponCreateDTO;
import com.ford.demo.companyclient.dto.CouponResponseDTO;
import com.ford.demo.companyclient.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/api")
public class CouponController {
    @Autowired
    CouponService couponService;
    @PostMapping("/generate")
    public ResponseEntity<String> generateCoupon(@RequestBody CouponCreateDTO couponCreateDTO){
        return new ResponseEntity<String>(couponService.generate(couponCreateDTO), HttpStatus.OK);
    }

    @GetMapping("/view/{companyName}")
    public  ResponseEntity<String> viewCoupon(@PathVariable String companyName){
        System.out.println("in view controller COmpanyClient");
        return new ResponseEntity<String>(couponService.view(companyName),HttpStatus.OK);
    }
}
