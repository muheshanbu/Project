package com.ford.apps.repository;

import com.ford.apps.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ICouponRepository extends JpaRepository<Coupon, Long> {
    public Coupon findByDenominations();
}
