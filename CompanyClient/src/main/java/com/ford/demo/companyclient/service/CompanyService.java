package com.ford.demo.companyclient.service;

import com.ford.demo.companyclient.dto.CompanyDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {
    WebClient client = WebClient.create("http://localhost:8081/CouponManagementSystem/api");

    // Define the request and URI

    public String createCompany(CompanyDTO companyDTO){
        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/company/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(companyDTO)); // Replace 'YourObject' with your actual object

        // Retrieve the response
        Mono<String> responseSpec = request.retrieve().bodyToMono(String.class);
        return responseSpec.block();


    }
}
