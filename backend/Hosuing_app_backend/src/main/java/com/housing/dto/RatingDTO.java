package com.housing.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RatingDTO {
	
	private Long id;
	
	@NotNull(message = "{rating.rating.absent}")
	@Min(value = 0, message = "{rating.rating.invalid}")
	@Max(value = 10, message = "{rating.rating.invalid}")
	private Integer rating;
	
	private ProfessionalDTO professionalDTO;
	
	private UserDTO userDTO;

	public RatingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingDTO(Long id,
			@NotNull(message = "{rating.rating.absent}") @Min(value = 0, message = "{rating.rating.invalid}") @Max(value = 10, message = "{rating.rating.invalid}") Integer rating,
			ProfessionalDTO professionalDTO, UserDTO userDTO) {
		super();
		this.id = id;
		this.rating = rating;
		this.professionalDTO = professionalDTO;
		this.userDTO = userDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public ProfessionalDTO getProfessionalDTO() {
		return professionalDTO;
	}

	public void setProfessionalDTO(ProfessionalDTO professionalDTO) {
		this.professionalDTO = professionalDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public String toString() {
		return "RatingDTO [id=" + id + ", rating=" + rating + ", professionalDTO=" + professionalDTO + ", userDTO="
				+ userDTO + "]";
	}
	
}
