package com.timeslot.booking.timeslotbooking.endpoint;

import com.timeslot.booking.timeslotbooking.application.service.ExternalWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExternalWeatherController {

    @Autowired
    ExternalWeatherService externalWeatherService;

    @GetMapping("/current-weather")
    public String getCurrentWeather(@RequestParam String city) {
        String response = externalWeatherService.getCurrentWeatherReport(city);
        return response;
    }
}
