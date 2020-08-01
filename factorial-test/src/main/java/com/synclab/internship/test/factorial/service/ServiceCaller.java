package com.synclab.internship.test.factorial.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Service
public class ServiceCaller {

    private RestTemplate restTemplate;

    @Autowired
    ServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public CompletableFuture<String> callOtherService(String value) {
        Instant start = Instant.now();

        String otherServiceEndpoint = "http://localhost:8080/factorial/" + value;
        String responseObject = restTemplate.getForObject(otherServiceEndpoint, String.class);

        System.out.println("Response: " + responseObject + " (" + Duration.between(start, Instant.now()).toMillis() + "ms)");
        return CompletableFuture.completedFuture(responseObject);
    }
}
