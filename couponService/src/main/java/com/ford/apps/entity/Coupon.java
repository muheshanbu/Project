package com.ford.apps.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponId;
    private String name;
    private String code;
    private String expDate;
    private int denomination;
    @ManyToOne(optional = false)
    Company company;
    //private boolean isIssued;
}
