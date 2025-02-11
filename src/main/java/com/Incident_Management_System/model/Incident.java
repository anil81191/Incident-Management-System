package com.Incident_Management_System.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Incident ID is required")
    @Column(unique = true)
    private String incidentId;

    @NotBlank(message = "Reporter name is required")
    private String reporterName;

    @NotBlank(message = "Incident details are required")
    private String details;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime reportedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getReportedAt() {
		return reportedAt;
	}

	public void setReportedAt(LocalDateTime reportedAt) {
		this.reportedAt = reportedAt;
	}

	@Override
	public String toString() {
		return "Incident [id=" + id + ", incidentId=" + incidentId + ", reporterName=" + reporterName + ", details="
				+ details + ", priority=" + priority + ", status=" + status + ", reportedAt=" + reportedAt + "]";
	}
	
	

   
}


