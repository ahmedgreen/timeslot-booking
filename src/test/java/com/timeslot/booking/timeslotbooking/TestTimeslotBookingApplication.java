package com.timeslot.booking.timeslotbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTimeslotBookingApplication {

    public static void main(String[] args) {
        SpringApplication.from(TimeslotBookingApplication::main).with(TestTimeslotBookingApplication.class).run(args);
    }

}
