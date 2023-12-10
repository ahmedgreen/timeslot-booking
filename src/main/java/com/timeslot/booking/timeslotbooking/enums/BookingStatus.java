package com.timeslot.booking.timeslotbooking.enums;

import java.util.HashMap;
import java.util.Map;

public enum BookingStatus implements BaseEnum {
    BOOKED("10"),
    CANCEL("20");

    private final String value;

    BookingStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    private static final Map<String, BookingStatus> VALUE_MAP = new HashMap<>();
    static {
        for(BookingStatus status: BookingStatus.values()){
            VALUE_MAP.put(status.value, status);
        }
    }

    public static BookingStatus getByValue(String value){
        return VALUE_MAP.get(value);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public String getVal() {
        return value;
    }
}
