package com.timeslot.booking.timeslotbooking.application.domain;


import com.timeslot.booking.timeslotbooking.converter.TimeSlotStatusConverter;
import com.timeslot.booking.timeslotbooking.enums.TimeSlotStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIME_SLOT_INFO")
public class TimeSlotEntity extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SLOT_ID", nullable = false)
    Long slotId;

    @Column(name = "SLOT_TITLE", nullable = false)
    String title;

    @Column(name = "START_TIME", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "END_TIME", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "TIME_SLOT_STAT", nullable = false)
    @Convert(converter = TimeSlotStatusConverter.class)
    TimeSlotStatus status;
}
