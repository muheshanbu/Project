package com.ford.demo.companyclient.dto;



//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
//    @Id
    private Integer  id;
    private String name;


    List<Coupon> coupons;



}

