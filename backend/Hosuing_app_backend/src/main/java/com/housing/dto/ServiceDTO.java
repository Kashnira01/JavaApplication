package com.housing.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ServiceDTO {
	
	private Long id;

	@NotNull(message = "{service.serviceName.absent}")
	@Size(max = 50, message = "{service.serviceName.invalid}")
	private String serviceName;

	@NotNull(message = "{service.timeRequired.absent}")
	@Positive(message = "{service.timeRequired.invalid}")
	private Integer timeRequired;

	@NotNull(message = "{service.price.absent}")
	@PositiveOrZero(message = "{service.price.invalid}")
	private Integer price = 0;

	@NotNull(message = "{service.description.absent}")
	@Size(max = 250, message = "{service.description.invalid}")
	private String serviceDescription;

	public ServiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceDTO(Long id,
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
		return "ServiceDTO [id=" + id + ", serviceName=" + serviceName + ", timeRequired=" + timeRequired + ", price="
				+ price + ", serviceDescription=" + serviceDescription + "]";
	}
	
}
