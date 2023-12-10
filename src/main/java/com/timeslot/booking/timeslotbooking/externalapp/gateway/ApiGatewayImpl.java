package com.timeslot.booking.timeslotbooking.externalapp.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ApiGatewayImpl implements ApiGateway{
//    @Autowired
//    RestTemplate restTemplate;
    private final RestTemplate restTemplate;

    @Autowired
    public ApiGatewayImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public <T> T get(URI uri, Class<T> responseType) {
        return restTemplate.getForObject(uri, responseType);
    }

    @Override
    public <T> ResponseEntity<T> getEntity(URI uri, Class<T> responseType){
        return restTemplate.getForEntity(uri, responseType);
    }

    @Override
    public <T> T get(String url, Class<T> responseType, Object... urlVariables) {
        return restTemplate.getForObject(url,responseType, urlVariables);
    }

    @Override
    public <T> T post(String url, Object request, Class<T> responseType, Object... urlVariables) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<>(request, headers);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType, urlVariables).getBody();
    }

    @Override
    public <T> T post(String url, HttpEntity<?> requestEntity, Class<T> responseType, Object... urlVariables) {
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType, urlVariables).getBody();
    }
}
