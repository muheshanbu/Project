package com.ford.apps.service;

import com.ford.apps.entity.Coupon;
import com.ford.apps.repository.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements ICouponService{
    @Autowired
    private ICouponRepository couponRepository;

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon issueCoupon(long couponId, long companyId) {

        Optional<Coupon> couponOpt = couponRepository.findById(couponId);

        if(!couponOpt.isPresent()){
            throw new EntityNotFoundException("Coupon Not Found");
        }
        Coupon coupon = couponOpt.get();

        return coupon;
    }

    @Override
    public Coupon getCouponById(Long id) {
        return couponRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public List<Coupon> requestCouponsWithDenomination(int couponCount, int denomination) {
        List<Coupon> couponsList;
        return null;
    }


    @Override
    public Coupon updateCoupon(Coupon coupon) {

        return couponRepository.save(coupon);
    }

    @Override
    public boolean deleteCoupon(Long id) {
        couponRepository.deleteById(id);
        return true;
    }
}
