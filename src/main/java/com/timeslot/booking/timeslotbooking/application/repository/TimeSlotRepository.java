package com.timeslot.booking.timeslotbooking.application.repository;


import com.timeslot.booking.timeslotbooking.application.domain.TimeSlotEntity;
import com.timeslot.booking.timeslotbooking.enums.TimeSlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Long> {
    List<TimeSlotEntity> findAllByStatus(TimeSlotStatus status);
}
