package com.robert.api.controller;

import com.robert.api.model.dto.ApiDTO;
import com.robert.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;


    @GetMapping
    public ResponseEntity<Flux<ApiDTO>> jobs(@RequestParam String engine, @RequestParam String q){
        return new ResponseEntity<>(apiService.jobs(engine, q), HttpStatus.OK);
    }
}
