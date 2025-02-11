package com.Incident_Management_System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Incident_Management_System.model.Incident;
import com.Incident_Management_System.services.IncidentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public ResponseEntity<Incident> createIncident(@Valid @RequestBody Incident incident) {
        return ResponseEntity.ok(incidentService.createIncident(incident));
    }

    @GetMapping("/{incidentId}")
    public ResponseEntity<Incident> getIncident(@PathVariable String incidentId) {
        return ResponseEntity.ok(incidentService.getIncident(incidentId));
    }

    @GetMapping("/user/{reporterName}")
    public ResponseEntity<List<Incident>> getUserIncidents(@PathVariable String reporterName) {
        return ResponseEntity.ok(incidentService.getUserIncidents(reporterName));
    }

    @PutMapping("/{incidentId}")
    public ResponseEntity<Incident> updateIncident(
            @PathVariable String incidentId,
            @Valid @RequestBody Incident updatedIncident) {
        return ResponseEntity.ok(incidentService.updateIncident(incidentId, updatedIncident));
    }
}
