package com.housing.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.housing.utility.UserStatus;
import com.housing.utility.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user_tbl", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NotNull(message = "{user.userType.absent}")
	@Enumerated(EnumType.STRING)
	@Column(name = "userType", nullable = false, length = 15)
	private UserType userType = UserType.USER;

	@NotNull(message = "{user.visitedToday.absent}")
	@Column(name = "visitedToday", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean visitedToday;

	@NotNull(message = "{user.flagged.absent}")
	@Column(name = "flagged", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean flagged;

	@NotNull(message = "{user.status.absent}")
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 15)
	private UserStatus status = UserStatus.PENDING;

	@NotNull(message = "{user.firstName.absent}")
	@Size(max = 50, message = "{user.firstName.invalid}")
	@Column(name = "firstName", nullable = false, length = 50)
	private String firstName;

	@Size(max = 50, message = "{user.lastName.invalid}")
	@Column(name = "lastName", length = 50)
	private String lastName;

	@NotNull(message = "user.email.absent")
	@Size(max = 150, message = "user.email.invalid")
	@Email(message = "user.email.invalid")
	@Column(name = "email", length = 150, nullable = false, unique = true)
	private String email;

	@NotNull(message = "{user.username.absent}")
	@Size(max = 50, message = "{user.username.invalid}")
	@Column(name = "username", length = 150, nullable = false, unique = true)
	private String username;

	@NotBlank(message = "{user.password.absent}")
	@Size(min = 6, max = 1500, message = "{user.password.invalid}")
	@Column(name = "password", length = 1500, nullable = false)
	private String password;

	@NotNull(message = "{user.address.absent}")
	@Size(max = 300, message = "{user.address.invalid}")
	@Column(name = "address", length = 300, nullable = false)
	private String address;

	@NotNull(message = "{user.pincode.absent}")
	@Min(value = 100000, message = "{user.pincode.invalid}")
	@Max(value = 999999, message = "{user.pincode.invalid}")
	@Column(name = "pincode", nullable = false)
	private Integer pincode;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Rating> ratings = new ArrayList<>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
	private Professional professional;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id,
			@NotNull(message = "{user.userType.absent}") UserType userType,
			@NotNull(message = "{user.visitedToday.absent}") Boolean visitedToday,
			@NotNull(message = "{user.flagged.absent}") Boolean flagged,
			@NotNull(message = "{user.status.absent}") UserStatus status,
			@NotNull(message = "{user.firstName.absent}") @Size(max = 50, message = "{user.firstName.invalid}") String firstName,
			@Size(max = 50, message = "{user.lastName.invalid}") String lastName,
			@NotNull(message = "user.email.absent") @Size(max = 150, message = "user.email.invalid") @Email(message = "user.email.invalid") String email,
			@NotNull(message = "{user.username.absent}") @Size(max = 50, message = "{user.username.invalid}") String username,
			@NotBlank(message = "{user.password.absent}") @Size(min = 6, max = 1500, message = "{user.password.invalid}") String password,
			@NotNull(message = "{user.address.absent}") @Size(max = 300, message = "{user.address.invalid}") String address,
			@NotNull(message = "{user.pincode.absent}") @Min(value = 100000, message = "{user.pincode.invalid}") @Max(value = 999999, message = "{user.pincode.invalid}") Integer pincode,
			List<Rating> ratings, Professional professional) {
		super();
		this.id = id;
		this.userType = userType;
		this.visitedToday = visitedToday;
		this.flagged = flagged;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.pincode = pincode;
		this.ratings = ratings;
		this.professional = professional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Boolean getVisitedToday() {
		return visitedToday;
	}

	public void setVisitedToday(Boolean visitedToday) {
		this.visitedToday = visitedToday;
	}

	public Boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(Boolean flagged) {
		this.flagged = flagged;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userType=" + userType + ", visitedToday=" + visitedToday + ", flagged=" + flagged
				+ ", status=" + status + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", address=" + address + ", pincode=" + pincode
				+ ", ratings=" + ratings + ", professional=" + professional + "]";
	}
	
}
