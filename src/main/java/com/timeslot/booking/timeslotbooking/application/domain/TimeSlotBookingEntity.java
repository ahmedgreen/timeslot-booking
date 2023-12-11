package com.timeslot.booking.timeslotbooking.application.domain;


import com.timeslot.booking.timeslotbooking.converter.TimeSlotBookingStatusConverter;
import com.timeslot.booking.timeslotbooking.enums.BookingStatus;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIME_SLOT_BOOKING_INFO")
@EqualsAndHashCode(callSuper=false)
public class TimeSlotBookingEntity extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    Long id;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "SLOT_ID")
    Long slotId;

    @Column(name = "BOOK_STAT")
    @Convert(converter = TimeSlotBookingStatusConverter.class)
    BookingStatus bookingStatus;


}
