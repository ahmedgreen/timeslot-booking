package com.timeslot.booking.timeslotbooking.application.service;

import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotCreateRequest;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotResponse;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotUpdateRequest;

import java.util.List;

public interface TimeSlotMgntService {
    List<TimeSlotResponse> getAllTimeSlot();

    List<TimeSlotResponse> getAllAvailableTimeSlot();

    TimeSlotResponse createNewTimeSlot(TimeSlotCreateRequest newTimeSlot);

    TimeSlotResponse getTimeSlotInfo(Long id);

    TimeSlotResponse updateTimeSlotInfo(TimeSlotUpdateRequest updateRequest, Long id);
}
