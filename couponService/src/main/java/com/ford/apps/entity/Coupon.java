package com.ford.apps.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponId;
    private String name;
    private String code;
    private String expDate;
    private int denomination;
/*    @ManyToOne
    Company company;*/
    //private boolean isIssued;
}
