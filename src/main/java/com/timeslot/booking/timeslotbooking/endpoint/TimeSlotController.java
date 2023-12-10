package com.timeslot.booking.timeslotbooking.endpoint;

import com.timeslot.booking.timeslotbooking.application.service.TimeSlotMgntService;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotCreateRequest;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotResponse;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-slot")
public class TimeSlotController {

    @Autowired
    TimeSlotMgntService service;

    @GetMapping("")
    List<TimeSlotResponse> all() {
        return service.getAllTimeSlot();
    }

    @GetMapping("/active")
    List<TimeSlotResponse> allActive() {
        return service.getAllAvailableTimeSlot();
    }

    @PostMapping("")
    TimeSlotResponse newTimeSlot(@RequestBody @Validated TimeSlotCreateRequest newTimeSlot) {
        return service.createNewTimeSlot(newTimeSlot);
    }

    // Single item

    @GetMapping("/{id}")
    TimeSlotResponse one(@PathVariable Long id) {
        return service.getTimeSlotInfo(id);
    }

    @PutMapping("/{id}")
    TimeSlotResponse replaceEmployee(@RequestBody TimeSlotUpdateRequest updateRequest, @PathVariable Long id) {

        return service.updateTimeSlotInfo(updateRequest, id);
    }

//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}
