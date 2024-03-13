package com.ford.demo.companyclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    List<CouponDTO> couponsDTOS=new ArrayList<>();
    public void addCouponDTO(Long id,String name,Integer denomination,String code,String expDate){
        this.couponsDTOS.add(new CouponDTO(id,name,denomination,code,expDate));
    }

}
