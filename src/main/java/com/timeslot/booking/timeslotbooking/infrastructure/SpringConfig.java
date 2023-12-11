//package com.timeslot.booking.timeslotbooking.infrastructure;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//
//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan("com.timeslot.booking.timeslotbooking")
//public class SpringConfig {
//
//    @Bean
//    @Qualifier("customRestTemplateCustomizer")
//    public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
//        return new CustomRestTemplateCustomizer();
//    }
//
//    @Bean
//    @DependsOn(value = {"customRestTemplateCustomizer"})
//    public RestTemplateBuilder restTemplateBuilder() {
//        return new RestTemplateBuilder(customRestTemplateCustomizer());
//    }
//
//}