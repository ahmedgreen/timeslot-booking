package com.timeslot.booking.timeslotbooking.application.service;

import com.timeslot.booking.timeslotbooking.externalapp.model.CurrentWeather;

public interface ExternalWeatherService {
    String getCurrentWeatherReport(String city);
    CurrentWeather getCurrentWeatherReport(String city, String country);
}
