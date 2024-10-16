package com.housing.dto;

import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import com.housing.utility.ServiceRequestStatus;

public class ServiceRequestDTO {
	
	private Long id;

	private ServiceDTO serviceDTO;

	private UserDTO userDTO;

	private ProfessionalDTO professionalDTO;

	@NotNull(message = "{serviceRequest.requestStatus.absent}")
	@Size(max = 15, message = "{serviceRequest.requestStatus.invalid}")
	private ServiceRequestStatus requestStatus = ServiceRequestStatus.REQUESTED;

	@FutureOrPresent(message = "{serviceRequest.requestDate.invalid}")
	private LocalDate requestDate = LocalDate.now();

	@PastOrPresent(message = "serviceRequest.completionDate.invalid")
	private LocalDate completionDate;

	@Size(max = 1000, message = "{serviceRequest.feedback.invalid}")
	private String feedback;

	public ServiceRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceRequestDTO(Long id, ServiceDTO serviceDTO, UserDTO userDTO, ProfessionalDTO professionalDTO,
			@NotNull(message = "{serviceRequest.requestStatus.absent}") @Size(max = 15, message = "{serviceRequest.requestStatus.invalid}") ServiceRequestStatus requestStatus,
			@FutureOrPresent(message = "{serviceRequest.requestDate.invalid}") LocalDate requestDate,
			@PastOrPresent(message = "serviceRequest.completionDate.invalid") LocalDate completionDate,
			@Size(max = 1000, message = "{serviceRequest.feedback.invalid}") String feedback) {
		super();
		this.id = id;
		this.serviceDTO = serviceDTO;
		this.userDTO = userDTO;
		this.professionalDTO = professionalDTO;
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

	public ServiceDTO getServiceDTO() {
		return serviceDTO;
	}

	public void setServiceDTO(ServiceDTO serviceDTO) {
		this.serviceDTO = serviceDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public ProfessionalDTO getProfessionalDTO() {
		return professionalDTO;
	}

	public void setProfessionalDTO(ProfessionalDTO professionalDTO) {
		this.professionalDTO = professionalDTO;
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
		return "ServiceRequestDTO [id=" + id + ", serviceDTO=" + serviceDTO + ", userDTO=" + userDTO
				+ ", professionalDTO=" + professionalDTO + ", requestStatus=" + requestStatus + ", requestDate="
				+ requestDate + ", completionDate=" + completionDate + ", feedback=" + feedback + "]";
	}
	
}
