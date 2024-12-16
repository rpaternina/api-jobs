package com.robert.api.service.impl;

import com.robert.api.model.dto.ApiDTO;
import com.robert.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final WebClient webClient;

    @Value("${api.key}")
    private String API_KEY;

    @Override
    public Flux<ApiDTO> jobs(String engine, String q){

        return webClient.get().uri(uriBuilder -> uriBuilder
                .path("/search")
                .queryParam("api_key", API_KEY)
                .queryParam("engine", engine)
                .queryParam("q", q)
                .build())
                .retrieve().bodyToFlux(ApiDTO.class);
    }
}
