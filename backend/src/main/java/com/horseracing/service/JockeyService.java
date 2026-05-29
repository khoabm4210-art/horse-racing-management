package com.horseracing.service;

import com.horseracing.entity.Jockey;
import com.horseracing.repository.JockeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Jockey Service - business logic for jockey management
 */
@Service
public class JockeyService {
    
    @Autowired
    private JockeyRepository jockeyRepository;
    
    public List<Jockey> getAllJockeys() {
        return jockeyRepository.findAll();
    }
    
    public Optional<Jockey> getJockeyById(Long id) {
        return jockeyRepository.findById(id);
    }
    
    public Jockey createJockey(Jockey jockey) {
        return jockeyRepository.save(jockey);
    }
    
    public Jockey updateJockey(Long id, Jockey jockeyDetails) {
        return jockeyRepository.findById(id).map(jockey -> {
            jockey.setName(jockeyDetails.getName());
            jockey.setCountry(jockeyDetails.getCountry());
            jockey.setWins(jockeyDetails.getWins());
            jockey.setRaces(jockeyDetails.getRaces());
            jockey.setBio(jockeyDetails.getBio());
            return jockeyRepository.save(jockey);
        }).orElseThrow(() -> new RuntimeException("Jockey not found"));
    }
    
    public void deleteJockey(Long id) {
        jockeyRepository.deleteById(id);
    }
}
