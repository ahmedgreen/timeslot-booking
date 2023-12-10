package com.timeslot.booking.timeslotbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotCreateRequest {
    @NotEmpty
    String title;

    @NotEmpty
    LocalDateTime startTime;

    @NotEmpty
    LocalDateTime endTime;
}
