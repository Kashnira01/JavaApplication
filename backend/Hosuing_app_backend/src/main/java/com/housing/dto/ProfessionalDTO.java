package com.housing.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ProfessionalDTO {
	
	private Long id;

	@NotNull(message = "{professional.serviceType.absent}")
	@Size(max = 50, message = "{professional.serviceType.invalid}")
	private String serviceType;

	@NotNull(message = "{professional.experience.absent}")
	@PositiveOrZero(message = "{professional.experience.invalid}")
	private Integer experience = 0;

	@NotNull(message = "{professional.description.absent}")
	@Size(max = 150, message = "{professional.description.invalid}")
	private String description;

	@NotNull(message = "{professional.joiningDate.absent}")
	@PastOrPresent(message = "{professional.joiningDate.invalid}")
	private LocalDate joiningDate = LocalDate.now();

	@NotNull(message = "{professional.availability.absent}")
	private Boolean availability = Boolean.TRUE;
		
	private UserDTO userDTO;

	public ProfessionalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfessionalDTO(Long id,
			@NotNull(message = "{professional.serviceType.absent}") @Size(max = 50, message = "{professional.serviceType.invalid}") String serviceType,
			@NotNull(message = "{professional.experience.absent}") @PositiveOrZero(message = "{professional.experience.invalid}") Integer experience,
			@NotNull(message = "{professional.description.absent}") @Size(max = 150, message = "{professional.description.invalid}") String description,
			@NotNull(message = "{professional.joiningDate.absent}") @PastOrPresent(message = "{professional.joiningDate.invalid}") LocalDate joiningDate,
			@NotNull(message = "{professional.availability.absent}") Boolean availability, UserDTO userDTO) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.experience = experience;
		this.description = description;
		this.joiningDate = joiningDate;
		this.availability = availability;
		this.userDTO = userDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public String toString() {
		return "ProfessionalDTO [id=" + id + ", serviceType=" + serviceType + ", experience=" + experience
				+ ", description=" + description + ", joiningDate=" + joiningDate + ", availability=" + availability
				+ ", userDTO=" + userDTO + "]";
	}
	
}
