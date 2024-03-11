package com.ford.apps.dto;

import com.ford.apps.entity.Coupon;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CouponResponseDTO {
    private Long id;
    private String name;
    private Integer denomination;
    private String code;
    private String expDate;
    private boolean isIssued;

    public static CouponResponseDTO fromEntity(Coupon coupon) {
        CouponResponseDTO dto = new CouponResponseDTO();
        dto.setId(coupon.getCouponId());
        dto.setName(coupon.getName());
        dto.setDenomination(coupon.getDenomination());
        dto.setCode(coupon.getCode());
        dto.setExpDate(coupon.getExpDate());
        dto.setIssued(coupon.isIssued());
        return dto;
    }
}
