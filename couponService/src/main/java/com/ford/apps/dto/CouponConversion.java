package com.ford.apps.dto;

import com.ford.apps.entity.Coupon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CouponConversion {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Coupon dtoToEntity(CouponCreateDTO dto) {
        Coupon coupon = new Coupon();
        coupon.setName(dto.getName());
        coupon.setDenomination(dto.getDenomination());
        coupon.setCode(dto.getCode());
        if (dto.getExpDate() != null && !dto.getExpDate().isEmpty()) {
            coupon.setExpDate(String.valueOf(LocalDate.parse(dto.getExpDate(), formatter)));
        }
        return coupon;
    }

    public static CouponCreateDTO entityToDto(Coupon coupon) {
        CouponCreateDTO dto = new CouponCreateDTO();
        dto.setName(coupon.getName());
        dto.setDenomination(coupon.getDenomination());
        dto.setCode(coupon.getCode());
        if (coupon.getExpDate() != null) {
            dto.setExpDate(coupon.getExpDate().format(String.valueOf(formatter)));
        }
        return dto;
    }
}
