package com.timeslot.booking.timeslotbooking.externalapp.dao;

import com.timeslot.booking.timeslotbooking.externalapp.gateway.ApiGateway;
import com.timeslot.booking.timeslotbooking.externalapp.model.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class ExternalApiDaoImpl implements ExternalApiDao {
    @Autowired
    ApiGateway apiGateWay;

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?";

    @Value("${openweathermap.api-key}")
    private String apiKey;

    @Override
    public ResponseEntity<String> getCurrentWeather(String city, String country){
        String urlString = WEATHER_URL + "q={city},{country}&appid={key}&units=metric";
        URI url = new UriTemplate(urlString).expand(city, country, apiKey);
        return apiGateWay.getEntity(url,String.class);
    }

    @Override
    public String getCurrentWeather(String city){
        String urlString = WEATHER_URL + "q={city}&appid={key}&units=metric";
        URI url = new UriTemplate(urlString).expand(city, apiKey);
        return apiGateWay.get(url,String.class);
    }
}
