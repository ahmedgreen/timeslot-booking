package com.timeslot.booking.timeslotbooking.converter;

import com.timeslot.booking.timeslotbooking.enums.BookingStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.ObjectUtils;

@Converter
public class TimeSlotBookingStatusConverter implements AttributeConverter<BookingStatus, String> {
    @Override
    public String convertToDatabaseColumn(BookingStatus attribute) {
        return ObjectUtils.isEmpty(attribute) ? null : attribute.getValue();
    }

    @Override
    public BookingStatus convertToEntityAttribute(String dbData) {
        return ObjectUtils.isEmpty(dbData)? null : BookingStatus.getByValue(dbData);
    }
}
