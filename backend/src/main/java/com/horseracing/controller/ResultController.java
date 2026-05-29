package com.horseracing.controller;

import com.horseracing.entity.Result;
import com.horseracing.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Race Results Management Controller
 */
@RestController
@RequestMapping("/results")
public class ResultController {
    
    @Autowired
    private ResultService resultService;
    
    /**
     * Get all results
     * GET /results
     */
    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        return ResponseEntity.ok(resultService.getAllResults());
    }
    
    /**
     * Get result by ID
     * GET /results/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        return resultService.getResultById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Create new result
     * POST /results
     */
    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result created = resultService.createResult(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    /**
     * Update result
     * PUT /results/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Result> updateResult(@PathVariable Long id, @RequestBody Result result) {
        Result updated = resultService.updateResult(id, result);
        return ResponseEntity.ok(updated);
    }
    
    /**
     * Delete result
     * DELETE /results/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}
