package com.timeslot.booking.timeslotbooking.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timeslot.booking.timeslotbooking.externalapp.dao.ExternalApiDao;
import com.timeslot.booking.timeslotbooking.externalapp.model.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExternalWeatherServiceImpl implements ExternalWeatherService{
    @Autowired
    ExternalApiDao externalApiDao;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String getCurrentWeatherReport(String city){
        return externalApiDao.getCurrentWeather(city);
    }

    @Override
    public CurrentWeather getCurrentWeatherReport(String city, String country){
        ResponseEntity<String> response = externalApiDao.getCurrentWeather(city, country);
        return convertJsonStringToCustomizeCurrentWeather(response);
    }

    private CurrentWeather convertJsonStringToCustomizeCurrentWeather(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            String description = root.path("weather").get(0).path("main").asText();
            BigDecimal temperature = BigDecimal.valueOf(root.path("main").path("temp").asDouble());
            BigDecimal feelsLike = BigDecimal.valueOf(root.path("main").path("feels_like").asDouble());
            BigDecimal windSpeed = BigDecimal.valueOf(root.path("wind").path("speed").asDouble());
            return CurrentWeather.builder()
                    .description(description)
                    .temperature(temperature)
                    .feelsLike(feelsLike)
                    .windSpeed(windSpeed)
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
