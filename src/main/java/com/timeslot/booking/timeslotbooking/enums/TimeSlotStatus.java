package com.timeslot.booking.timeslotbooking.enums;

import java.util.HashMap;
import java.util.Map;

public enum TimeSlotStatus implements BaseEnum {
    AVAILABLE("00"),
    BOOKED("10"),
    COMPLETE("20");

    private final String value;

    TimeSlotStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    private static final Map<String, TimeSlotStatus> VALUE_MAP = new HashMap<>();
    static {
        for(TimeSlotStatus status: TimeSlotStatus.values()){
            VALUE_MAP.put(status.value, status);
        }
    }

    public static TimeSlotStatus getByValue(String value){
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
