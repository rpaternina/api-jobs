package com.robert.api.service;

import com.robert.api.model.Api;
import com.robert.api.model.dto.ApiDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {

    Flux<ApiDTO> jobs(String engine, String q);

    Mono<Api> saveJob(ApiDTO apiDTO);
}
