package com.timeslot.booking.timeslotbooking;

import com.timeslot.booking.timeslotbooking.application.domain.TimeSlotEntity;
import com.timeslot.booking.timeslotbooking.application.repository.TimeSlotRepository;
import com.timeslot.booking.timeslotbooking.enums.TimeSlotStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TimeslotBookingApplicationTests {
    @Autowired
    TimeSlotRepository timeSlotRepository;

//	@Test
//	void contextLoads() {
//	}

    @Test
    void testSaveTimeSlot(){
        TimeSlotEntity entity = TimeSlotEntity.builder()
                .title("Test Time Slot")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .status(TimeSlotStatus.AVAILABLE)
                .build();
        TimeSlotEntity savedEntity = timeSlotRepository.save(entity);
        Assert.assertNotNull(savedEntity.getSlotId());
        Assert.assertNotNull(savedEntity.getCreated());
        Assert.assertNull(savedEntity.getUpdated());
        Assert.assertEquals(0, savedEntity.getVersion());
        Assert.assertEquals(entity, savedEntity);
    }

}
