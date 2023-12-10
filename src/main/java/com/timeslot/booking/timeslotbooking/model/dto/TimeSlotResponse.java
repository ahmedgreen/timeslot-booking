package com.timeslot.booking.timeslotbooking.model.dto;

import com.timeslot.booking.timeslotbooking.enums.TimeSlotStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotResponse {
    @NotNull
    Long id;

    @NotEmpty
    String title;

    @NotNull
    LocalDateTime startTime;

    @NotNull
    LocalDateTime endTime;

    TimeSlotStatus status;

    LocalDateTime created;
    LocalDateTime updated;
    Long version;
}
