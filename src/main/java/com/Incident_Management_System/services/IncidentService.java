package com.Incident_Management_System.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incident_Management_System.model.Incident;
import com.Incident_Management_System.model.Status;
import com.Incident_Management_System.repository.IncidentRepository;
import com.Incident_Management_System.util.DuplicateIncidentException;
import com.Incident_Management_System.util.ResourceNotFoundException;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public Incident createIncident(Incident incident) {
        if (incidentRepository.findByIncidentId(incident.getIncidentId()).isPresent()) {
            throw new DuplicateIncidentException("Incident ID must be unique");
        }
        return incidentRepository.save(incident);
    }

    public Incident getIncident(String incidentId) {
        return incidentRepository.findByIncidentId(incidentId)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with ID: " + incidentId));
    }

    public List<Incident> getUserIncidents(String reporterName) {
        return incidentRepository.findByReporterName(reporterName);
    }

    public Incident updateIncident(String incidentId, Incident updatedIncident) {
        Incident incident = getIncident(incidentId);
        if (incident.getStatus() == Status.CLOSED) {
            throw new IllegalStateException("Closed incidents cannot be edited");
        }
        incident.setDetails(updatedIncident.getDetails());
        incident.setPriority(updatedIncident.getPriority());
        incident.setStatus(updatedIncident.getStatus());
        return incidentRepository.save(incident);
    }
}

