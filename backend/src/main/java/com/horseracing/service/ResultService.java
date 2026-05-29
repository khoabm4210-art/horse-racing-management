package com.horseracing.service;

import com.horseracing.entity.Result;
import com.horseracing.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Result Service - business logic for race result management
 */
@Service
public class ResultService {
    
    @Autowired
    private ResultRepository resultRepository;
    
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
    
    public Optional<Result> getResultById(Long id) {
        return resultRepository.findById(id);
    }
    
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }
    
    public Result updateResult(Long id, Result resultDetails) {
        return resultRepository.findById(id).map(result -> {
            result.setRaceName(resultDetails.getRaceName());
            result.setRaceDate(resultDetails.getRaceDate());
            result.setVenue(resultDetails.getVenue());
            result.setWinner(resultDetails.getWinner());
            result.setJockey(resultDetails.getJockey());
            result.setTime(resultDetails.getTime());
            result.setPrize(resultDetails.getPrize());
            return resultRepository.save(result);
        }).orElseThrow(() -> new RuntimeException("Result not found"));
    }
    
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
