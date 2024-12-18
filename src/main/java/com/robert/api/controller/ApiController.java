package com.robert.api.controller;

import com.robert.api.model.Api;
import com.robert.api.model.dto.ApiDTO;
import com.robert.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;


    @GetMapping
    public ResponseEntity<Flux<ApiDTO>> jobs(@RequestParam String engine, @RequestParam String q){
        return new ResponseEntity<>(apiService.jobs(engine, q), HttpStatus.OK);
    }

    @PostMapping
    public Mono<ResponseEntity<String>> save(@RequestBody ApiDTO apiDTO){
        apiService.saveJob(apiDTO);
        return Mono.just(new ResponseEntity<> ("Datos guardados con exito" ,HttpStatus.CREATED));
    }
}
