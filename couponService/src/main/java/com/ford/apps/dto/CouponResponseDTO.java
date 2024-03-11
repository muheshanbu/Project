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
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class CouponDTO {
        private Long id;
        private String name;
        private Integer denomination;
        private String code;
        private String expDate;

    }
    String companyName;
    List<CouponResponseDTO.CouponDTO> couponsDTOS=new ArrayList<>();
    public void addCouponDTO(Long id,String name,Integer denomination,String code,String expDate){
        this.couponsDTOS.add(new CouponDTO(id,name,denomination,code,expDate));
    }

}
