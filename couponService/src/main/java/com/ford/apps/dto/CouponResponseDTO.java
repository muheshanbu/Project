package com.ford.apps.dto;

import com.ford.apps.entity.Coupon;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CouponResponseDTO {
    private class CouponsDTO {
        private Long id;
        private String name;
        private Integer denomination;
        private String code;
        private String expDate;
        private boolean isIssued;
    }
    String companyName;
    List<CouponResponseDTO.CouponsDTO> couponsDTOS=new ArrayList<>();
//    public static CouponResponseDTO fromEntity(Coupon coupon) {
//        CouponResponseDTO dto = new CouponResponseDTO();
//        dto.setId(coupon.getCouponId());
//        dto.setName(coupon.getName());
//        dto.setDenomination(coupon.getDenomination());
//        dto.setCode(coupon.getCode());
//        dto.setExpDate(coupon.getExpDate());
//        dto.setIssued(coupon.isIssued());
//        return dto;
//    }
}
