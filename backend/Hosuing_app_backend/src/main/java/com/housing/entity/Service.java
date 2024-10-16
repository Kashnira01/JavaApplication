package com.housing.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "service_tbl", uniqueConstraints = @UniqueConstraint(columnNames = { "serviceName" }))
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NotNull(message = "{service.serviceName.absent}")
	@Size(max = 50, message = "{service.serviceName.invalid}")
	@Column(name = "serviceName", nullable = false, length = 50, unique = true)
	private String serviceName;

	@NotNull(message = "{service.timeRequired.absent}")
	@Positive(message = "{service.timeRequired.invalid}")
	@Column(name = "timeRequired", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
	private Integer timeRequired;

	@NotNull(message = "{service.price.absent}")
	@PositiveOrZero(message = "{service.price.invalid}")
	@Column(name = "price", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
	private Integer price = 0;

	@NotNull(message = "{service.description.absent}")
	@Size(max = 250, message = "{service.description.invalid}")
	@Column(name = "serviceDescription", nullable = false, length = 250)
	private String serviceDescription;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(Long id,
			@NotNull(message = "{service.serviceName.absent}") @Size(max = 50, message = "{service.serviceName.invalid}") String serviceName,
			@NotNull(message = "{service.timeRequired.absent}") @Positive(message = "{service.timeRequired.invalid}") Integer timeRequired,
			@NotNull(message = "{service.price.absent}") @PositiveOrZero(message = "{service.price.invalid}") Integer price,
			@NotNull(message = "{service.description.absent}") @Size(max = 250, message = "{service.description.invalid}") String serviceDescription) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.timeRequired = timeRequired;
		this.price = price;
		this.serviceDescription = serviceDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(Integer timeRequired) {
		this.timeRequired = timeRequired;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName + ", timeRequired=" + timeRequired + ", price="
				+ price + ", serviceDescription=" + serviceDescription + "]";
	}
	
}
