package com.housing.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating_tbl")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@NotNull(message = "{rating.rating.absent}")
	@Min(value = 0, message = "{rating.rating.invalid}")
	@Max(value = 10, message = "{rating.rating.invalid}")
	@Column(name = "rating", nullable = false)
	private Integer rating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_id")
	private Professional professional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(Long id,
			@NotNull(message = "{rating.rating.absent}") @Min(value = 0, message = "{rating.rating.invalid}") @Max(value = 10, message = "{rating.rating.invalid}") Integer rating,
			Professional professional, User user) {
		super();
		this.id = id;
		this.rating = rating;
		this.professional = professional;
		this.user = user;
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

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", professional=" + professional + ", user=" + user + "]";
	}
	
}
