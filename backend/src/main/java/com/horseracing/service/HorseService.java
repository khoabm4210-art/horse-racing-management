package com.horseracing.service;

import com.horseracing.entity.Horse;
import com.horseracing.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Horse Service - business logic for horse management
 */
@Service
public class HorseService {
    
    @Autowired
    private HorseRepository horseRepository;
    
    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }
    
    public Optional<Horse> getHorseById(Long id) {
        return horseRepository.findById(id);
    }
    
    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    }
    
    public Horse updateHorse(Long id, Horse horseDetails) {
        return horseRepository.findById(id).map(horse -> {
            horse.setName(horseDetails.getName());
            horse.setBreed(horseDetails.getBreed());
            horse.setAge(horseDetails.getAge());
            horse.setSpeed(horseDetails.getSpeed());
            horse.setOwner(horseDetails.getOwner());
            horse.setStatus(horseDetails.getStatus());
            horse.setNotes(horseDetails.getNotes());
            return horseRepository.save(horse);
        }).orElseThrow(() -> new RuntimeException("Horse not found"));
    }
    
    public void deleteHorse(Long id) {
        horseRepository.deleteById(id);
    }
    
    public List<Horse> getHorsesByStatus(String status) {
        return horseRepository.findByStatus(status);
    }
}
