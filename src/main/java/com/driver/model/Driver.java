package com.driver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="driver")
public class Driver{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int driverId;
	private String mobile;
	private String password;
	@OneToMany(mappedBy="tripbooking", cascade=CascadeType.ALL)
	private List<TripBooking> tripBookingList= new ArrayList<>();
	
	@OneToOne(mappedBy="cab",cascade=CascadeType.ALL)
	private Cab cab;

	public Driver() {
		super();
	}

	public Driver(int driverId, String mobile, String password, List<TripBooking> tripBookingList, Cab cab) {
		super();
		this.driverId = driverId;
		this.mobile = mobile;
		this.password = password;
		this.tripBookingList = tripBookingList;
		this.cab = cab;
	}

	public int getDriverId() {
		return driverId;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return password;
	}

	public List<TripBooking> getTripBookingList() {
		return tripBookingList;
	}

	public Cab getCab() {
		return cab;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTripBookingList(List<TripBooking> tripBookingList) {
		this.tripBookingList = tripBookingList;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}
	
	
	
	
}