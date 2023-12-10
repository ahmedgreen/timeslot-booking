package com.timeslot.booking.timeslotbooking.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface BaseEnum {
    @JsonValue
    String getVal();
}
