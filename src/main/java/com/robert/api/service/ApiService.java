package com.robert.api.service;

import com.robert.api.model.dto.ApiDTO;
import reactor.core.publisher.Flux;

public interface ApiService {

    Flux<ApiDTO> jobs(String engine, String q);
}
