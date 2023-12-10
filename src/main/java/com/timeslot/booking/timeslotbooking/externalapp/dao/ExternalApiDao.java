package com.timeslot.booking.timeslotbooking.externalapp.dao;

import com.timeslot.booking.timeslotbooking.externalapp.model.CurrentWeather;
import org.springframework.http.ResponseEntity;

public interface ExternalApiDao {

    ResponseEntity<String> getCurrentWeather(String city, String country);

    String getCurrentWeather(String city);
}
