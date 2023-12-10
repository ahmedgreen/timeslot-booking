package com.timeslot.booking.timeslotbooking.converter;

import com.timeslot.booking.timeslotbooking.enums.TimeSlotStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.ObjectUtils;

@Converter
public class TimeSlotStatusConverter implements AttributeConverter<TimeSlotStatus, String> {
    @Override
    public String convertToDatabaseColumn(TimeSlotStatus attribute) {
        return ObjectUtils.isEmpty(attribute) ? null : attribute.getValue();
    }

    @Override
    public TimeSlotStatus convertToEntityAttribute(String dbData) {
        return ObjectUtils.isEmpty(dbData)? null : TimeSlotStatus.getByValue(dbData);
    }
}
