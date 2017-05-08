package com.usecase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Vehicle")
@Table(name = "VEHICLE")
public class Vehicle {
	@Id
	@Column(name = "VEHICLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	@Column(name = "ROUTE")
	private String route;
	@Column(name = "SEATS")
	private Integer noSeats;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Integer getNoSeats() {
		return noSeats;
	}

	public void setNoSeats(Integer noSeats) {
		this.noSeats = noSeats;
	}

}
