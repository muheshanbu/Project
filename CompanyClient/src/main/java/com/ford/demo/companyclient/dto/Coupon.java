package com.ford.demo.companyclient.dto;


//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
//    @Id
    private Integer couponId;
    private String name ;
    private String code ;
    private Integer denomination;
    private Date expDate;


    private Company company;
}

