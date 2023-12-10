package com.timeslot.booking.timeslotbooking.externalapp.gateway;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public interface ApiGateway {

    <T> T get(URI uri, Class<T> responseType);
    <T> T get(String url, Class<T> responseType, Object... urlVariables);
    <T> ResponseEntity<T> getEntity(URI uri, Class<T> responseType);

    <T> T post(String url, Object request, Class<T> responseType, Object... urlVariables);
    <T> T post(String url, HttpEntity<?> requestEntity, Class<T> responseType, Object... urlVariables);


}
