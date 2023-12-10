package com.timeslot.booking.timeslotbooking.infrastructure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

@Configuration
@Slf4j
public class ApplicationConfiguration {

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER =
            new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

//    @Bean
//    public ObjectMapper objectMapper(ObjectMapper objectMapper){
//        return objectMapper;
//    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
//        return restTemplateBuilder.setConnectTimeout(Duration.ofMillis(300000))
//                .setReadTimeout(Duration.ofMillis(300000)).build();
//    }
//
//    @Bean
//    public Module javaTimeModule() {
//        JavaTimeModule module = new JavaTimeModule();
//
//        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
//        return module;
//    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                .serializers(LOCAL_DATETIME_SERIALIZER);
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();

        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(module);
    }


}
