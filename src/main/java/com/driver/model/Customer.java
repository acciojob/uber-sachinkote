package com.driver.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class Customer{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int customerId;
	private String mobile;
	private String password;
	@OneToMany(mappedBy="tripbooking", cascade=CascadeType.ALL)
	List<TripBooking> tripBookingList=new ArrayList();
	
	
	public Customer() {
		super();
	}


	public Customer(int customerId, String mobile, String password, List<TripBooking> tripBookingList) {
		super();
		this.customerId = customerId;
		this.mobile = mobile;
		this.password = password;
		this.tripBookingList = tripBookingList;
	}


	public int getCustomerId() {
		return customerId;
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


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	
	
	
	
	
}