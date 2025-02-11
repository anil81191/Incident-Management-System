package com.Incident_Management_System.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateIncidentException extends RuntimeException {
    public DuplicateIncidentException(String message) {
        super(message);
    }
}