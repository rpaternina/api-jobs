package com.robert.api.service.impl;

import com.robert.api.model.Api;
import com.robert.api.model.dto.ApiDTO;
import com.robert.api.repository.ApiRepository;
import com.robert.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final WebClient webClient;
    private final ApiRepository apiRepository;

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
                .retrieve().bodyToFlux(ApiDTO.class)
                .doOnNext(apiDTO -> {
                    guardarDatos(apiDTO);});
    }

    private void guardarDatos(ApiDTO apiDTO){
        if(apiDTO.getJobs() != null){
            apiDTO.getJobs().forEach(
                    job -> {
                        Api api = Api.builder()
                                .title(job.getTitle())
                                .companyName(job.getCompanyName())
                                .applyLink(job.getApplyLink())
                                .build();
                        apiRepository.save(api);
                    }
            );
        }
    }

    @Override
    public Mono<Api> saveJob(ApiDTO apiDTO){

        if(apiDTO.getJobs() != null){
            apiDTO.getJobs().forEach(
                    job -> {
                        Api api = Api.builder()
                                .title(job.getTitle())
                                .companyName(job.getCompanyName())
                                .applyLink(job.getApplyLink())
                                .build();
                        apiRepository.save(api);
                    });
        }
        return null;
    }
}
