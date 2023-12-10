package com.timeslot.booking.timeslotbooking.application.service;

import com.timeslot.booking.timeslotbooking.application.domain.TimeSlotEntity;
import com.timeslot.booking.timeslotbooking.application.repository.TimeSlotRepository;
import com.timeslot.booking.timeslotbooking.enums.TimeSlotStatus;
import com.timeslot.booking.timeslotbooking.exception.DataNotFoundException;
import com.timeslot.booking.timeslotbooking.exception.InvalidDataException;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotCreateRequest;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotResponse;
import com.timeslot.booking.timeslotbooking.model.dto.TimeSlotUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSlotMgntServiceImpl implements TimeSlotMgntService {
//    @Autowired
    TimeSlotRepository repository;

    @Override
    public List<TimeSlotResponse> getAllTimeSlot() {
        List<TimeSlotEntity> timeSlotEntities = repository.findAll();
        return convertEntityToResponse(timeSlotEntities);
    }

    @Override
    public List<TimeSlotResponse> getAllAvailableTimeSlot() {
        List<TimeSlotEntity> timeSlotEntities = repository.findAllByStatus(TimeSlotStatus.AVAILABLE);
        return convertEntityToResponse(timeSlotEntities);
    }

    @Override
    public TimeSlotResponse createNewTimeSlot(TimeSlotCreateRequest newTimeSlot) {
        TimeSlotEntity newTimeSlotEntity = TimeSlotEntity.builder()
                .title(newTimeSlot.getTitle())
                .startTime(newTimeSlot.getStartTime())
                .endTime(newTimeSlot.getEndTime())
                .status(TimeSlotStatus.AVAILABLE)
                .build();
        return convertEntityToResponse(repository.save(newTimeSlotEntity));
    }


    @Override
    public TimeSlotResponse getTimeSlotInfo(Long id) {

        TimeSlotEntity entity = repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Timeslot not found for id + " + id));
        return convertEntityToResponse(entity);
    }


    @Override
    public TimeSlotResponse updateTimeSlotInfo(TimeSlotUpdateRequest updateRequest, Long id) {
        if (updateRequest.getId() != id) {
            throw new InvalidDataException("Slot id mismatch");
        }

        TimeSlotEntity updatedEntity = repository.findById(id)
                .map(entity -> {
                    entity.setTitle(updateRequest.getTitle());
                    entity.setStartTime(updateRequest.getStartTime());
                    entity.setEndTime(updateRequest.getEndTime());
                    entity.setStatus(updateRequest.getStatus());
                    return repository.save(entity);
                })
                .orElseGet(() -> {
                    throw new DataNotFoundException("Timeslot not found for id + " + id);
                });
        return convertEntityToResponse(updatedEntity);
    }

    private TimeSlotResponse convertEntityToResponse(TimeSlotEntity entity) {
        return TimeSlotResponse.builder()
                .id(entity.getSlotId())
                .title(entity.getTitle())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .status(entity.getStatus())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .version(entity.getVersion())
                .build();
    }

    private List<TimeSlotResponse> convertEntityToResponse(List<TimeSlotEntity> timeSlotEntities) {
        return timeSlotEntities.stream()
                .map(entity ->
                        convertEntityToResponse(entity)
                )
                .collect(Collectors.toList());
    }
}
