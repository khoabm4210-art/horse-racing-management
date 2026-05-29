package com.horseracing.service;

import com.horseracing.entity.Schedule;
import com.horseracing.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Schedule Service - business logic for race schedule management
 */
@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;
    
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
    
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
    
    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        return scheduleRepository.findById(id).map(schedule -> {
            schedule.setName(scheduleDetails.getName());
            schedule.setRaceDate(scheduleDetails.getRaceDate());
            schedule.setVenue(scheduleDetails.getVenue());
            schedule.setHorseCount(scheduleDetails.getHorseCount());
            schedule.setPrize(scheduleDetails.getPrize());
            schedule.setStatus(scheduleDetails.getStatus());
            return scheduleRepository.save(schedule);
        }).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }
    
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
    
    public List<Schedule> getSchedulesByStatus(String status) {
        return scheduleRepository.findByStatus(status);
    }
}
