package com.ford.apps.service;

import com.ford.apps.dto.CouponCreateDTO;
import com.ford.apps.dto.CouponResponseDTO;
import com.ford.apps.entity.Coupon;

import java.util.List;

public interface ICouponService {

    public Coupon createCoupon(Coupon coupon);

    public Coupon issueCoupon(long couponId, long companyId);
    public Coupon getCouponById(Long id);
    public List<Coupon> getAllCoupons();

    //takes CouponCreateDTO and returns the newly created coupons as coupon create DTO
    public CouponResponseDTO generateCoupons(CouponCreateDTO couponCreateDTO);

    public CouponResponseDTO viewCoupons(String companyName);




    public List<Coupon> requestCouponsWithDenomination(int denomination, int couponCount);

//    public List<Coupon> getCouponsByDenomination(Integer denomination);

    public Coupon updateCoupon(Coupon couponDetails);

    public boolean deleteCoupon(Long id);
}
