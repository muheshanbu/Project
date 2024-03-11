package com.ford.apps.service;

import com.ford.apps.dto.CouponCreateDTO;
import com.ford.apps.dto.CouponResponseDTO;
import com.ford.apps.entity.Company;
import com.ford.apps.entity.Coupon;
import com.ford.apps.repository.ICompanyRepository;
import com.ford.apps.repository.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CouponServiceImpl implements ICouponService{
    @Autowired
    private ICouponRepository couponRepository;
    @Autowired
    private ICompanyRepository companyRepository;



    @Override
    public Coupon createCoupon(int denomination) {
        Coupon coupon = new Coupon();
        // Set properties accordingly. Example:
        coupon.setCode(UUID.randomUUID().toString()); // Assuming unique code generation
        coupon.setExpDate("2024-06-31"); // Example expiration date
        coupon.setDenomination(denomination);
//        return coupon;
        return coupon;
    }

    @Override
    public List<Coupon> issueCoupon(double amount) {
        final int[] DENOMINATIONS = new int[] {1000, 500, 100, 1};
        List<Coupon> issuedCoupons = new ArrayList<>();
        for (int denomination : DENOMINATIONS) {
            while (amount >= denomination) {
                Coupon coupon = createCoupon(denomination);
                //couponRepository.save(coupon);
                issuedCoupons.add(coupon);
                amount -= denomination;
            }
        }
        return issuedCoupons;
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
    public CouponResponseDTO generateCoupons(CouponCreateDTO couponCreateDTO) {
        List<Coupon> coupons =issueCoupon(couponCreateDTO.getAmount());
        Company company=companyRepository.findByCompanyName(couponCreateDTO.getName()).get(0);
        CouponResponseDTO couponResponseDTO=new CouponResponseDTO();
        couponResponseDTO.setCompanyName(couponCreateDTO.getName());

        for(Coupon coupon:coupons){
            coupon.setCompany(company);
            couponRepository.save(coupon);
            couponResponseDTO.addCouponDTO(coupon.getCouponId(),coupon.getName(),coupon.getDenomination(),coupon.getCode(),coupon.getExpDate());

        }
        return couponResponseDTO;
    }

    @Override
    public CouponResponseDTO viewCoupons(String companyName) {
        return null;
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
