package com.ford.demo.companyclient.service;

import com.ford.demo.companyclient.dto.CouponCreateDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.RequestEntity.post;

@Service
public class CouponService {
    WebClient client= WebClient.create("http://localhost:8081/CouponManagementSystem/api");
    public String generate(CouponCreateDTO couponCreateDTO){
        WebClient.RequestHeadersSpec<?> request= client.post().uri("/coupons/generate").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(couponCreateDTO));
        String response=request.retrieve().bodyToMono(String.class).block();
        return response;


    }

    public  String view(String name){
        WebClient.RequestHeadersSpec<?> request= client.get().uri("/coupons/view_coupon/"+name);
        String response=request.retrieve().bodyToMono(String.class).block();
        return response;

    }
}
