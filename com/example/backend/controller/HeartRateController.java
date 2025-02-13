package com.example.backend.controller;

import com.example.backend.entity.HeartRate;
import com.example.backend.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heartrates")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/{patientId}")
    public ResponseEntity<HeartRate> addHeartRate(@PathVariable Long patientId, @RequestBody HeartRate heartRate) {
        heartRate.setPatientId(patientId);
        return ResponseEntity.ok(heartRateService.addHeartRate(heartRate));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<HeartRate>> getHeartRates(@PathVariable Long patientId) {
        return ResponseEntity.ok(heartRateService.getHeartRatesByPatientId(patientId));
    }
}