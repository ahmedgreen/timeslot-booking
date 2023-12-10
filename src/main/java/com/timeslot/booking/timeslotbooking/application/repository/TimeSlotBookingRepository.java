package com.timeslot.booking.timeslotbooking.application.repository;

import com.timeslot.booking.timeslotbooking.application.domain.TimeSlotBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotBookingRepository extends JpaRepository<TimeSlotBookingEntity, Long> {
}
