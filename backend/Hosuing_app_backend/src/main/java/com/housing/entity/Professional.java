package com.housing.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "professional_tbl")
public class Professional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NotNull(message = "{professional.serviceType.absent}")
	@Size(max = 50, message = "{professional.serviceType.invalid}")
	@Column(name = "serviceType", nullable = false, length = 50)
	private String serviceType;

	@NotNull(message = "{professional.experience.absent}")
	@PositiveOrZero(message = "{professional.experience.invalid}")
	@Column(name = "experience", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
	private Integer experience = 0;

	@NotNull(message = "{professional.description.absent}")
	@Size(max = 150, message = "{professional.description.invalid}")
	@Column(name = "description", length = 150)
	private String description;

	@NotNull(message = "{professional.joiningDate.absent}")
	@PastOrPresent(message = "{professional.joiningDate.invalid}")
	@Column(name = "joiningDate", nullable = false)
	private LocalDate joiningDate = LocalDate.now();

	@NotNull(message = "{professional.availability.absent}")
	@Column(name = "availability", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean availability;

	@OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Rating> ratings = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Professional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professional(Long id,
			@NotNull(message = "{professional.serviceType.absent}") @Size(max = 50, message = "{professional.serviceType.invalid}") String serviceType,
			@NotNull(message = "{professional.experience.absent}") @PositiveOrZero(message = "{professional.experience.invalid}") Integer experience,
			@NotNull(message = "{professional.description.absent}") @Size(max = 150, message = "{professional.description.invalid}") String description,
			@NotNull(message = "{professional.joiningDate.absent}") @PastOrPresent(message = "{professional.joiningDate.invalid}") LocalDate joiningDate,
			@NotNull(message = "{professional.availability.absent}") Boolean availability, List<Rating> ratings,
			User user) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.experience = experience;
		this.description = description;
		this.joiningDate = joiningDate;
		this.availability = availability;
		this.ratings = ratings;
		this.user = user;
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

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Professional [id=" + id + ", serviceType=" + serviceType + ", experience=" + experience
				+ ", description=" + description + ", joiningDate=" + joiningDate + ", availability=" + availability
				+ ", ratings=" + ratings + ", user=" + user + "]";
	}
	
	
}