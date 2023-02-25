package com.driver.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cab")
public class Cab{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	private int perKmRate;
	private boolean available;
	@JoinColumn
	@OneToOne
	private Driver driver;
	
	public Cab() {
		super();
	}

	public Cab(int cabId, int perKmRate, boolean available, Driver driver) {
		super();
		this.Id = Id;
		this.perKmRate = perKmRate;
		this.available = available;
		this.driver = driver;
	}

	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPerKmRate() {
		return perKmRate;
	}

	public boolean getAvailable() {
		return available;
	}

	public Driver getDriver() {
		return driver;
	}

	

	public void setPerKmRate(int perKmRate) {
		this.perKmRate = perKmRate;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	
}
