package com.housing.entity;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.housing.utility.ServiceRequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_request_tbl")
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private Service service;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "professional_id", nullable = false)
	private Professional professional;

	@NotNull(message = "{serviceRequest.requestStatus.absent}")
	@Enumerated(EnumType.STRING)
	@Size(max = 15, message = "{serviceRequest.requestStatus.invalid}")
	@Column(name = "requestStatus", nullable = false, length = 15)
	private ServiceRequestStatus requestStatus = ServiceRequestStatus.REQUESTED;

	@FutureOrPresent(message = "{serviceRequest.requestDate.invalid}")
	@Column(name = "requestDate", nullable = false)
	private LocalDate requestDate = LocalDate.now();

	@PastOrPresent(message = "serviceRequest.completionDate.invalid")
	@Column(name = "completionDate")
	private LocalDate completionDate;

	@Size(max = 1000, message = "{serviceRequest.feedback.invalid}")
	@Column(name = "feedback", nullable = false, length = 1000)
	private String feedback;

	public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceRequest(Long id, Service service, User user, Professional professional,
			@NotNull(message = "{serviceRequest.requestStatus.absent}") @Size(max = 15, message = "{serviceRequest.requestStatus.invalid}") ServiceRequestStatus requestStatus,
			@FutureOrPresent(message = "{serviceRequest.requestDate.invalid}") LocalDate requestDate,
			@PastOrPresent(message = "serviceRequest.completionDate.invalid") LocalDate completionDate,
			@Size(max = 1000, message = "{serviceRequest.feedback.invalid}") String feedback) {
		super();
		this.id = id;
		this.service = service;
		this.user = user;
		this.professional = professional;
		this.requestStatus = requestStatus;
		this.requestDate = requestDate;
		this.completionDate = completionDate;
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public ServiceRequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(ServiceRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", service=" + service + ", user=" + user + ", professional=" + professional
				+ ", requestStatus=" + requestStatus + ", requestDate=" + requestDate + ", completionDate="
				+ completionDate + ", feedback=" + feedback + "]";
	}
	
}
