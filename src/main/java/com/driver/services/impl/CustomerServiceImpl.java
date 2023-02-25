package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer c=customerRepository2.findById(customerId).get();
		customerRepository2.delete(c);
		
	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		TripBooking tb=new TripBooking();
		Driver d=null;
		List<Driver> l=driverRepository2.findAll();
		for(Driver driver:l)
		{
			if(driver.getCab().isAvailable()==Boolean.TRUE)
			{
				if((d==null)|| (driver.getDriverId()>driver.getDriverId()))
				{
					d=driver;
				}
			}
		}
		if(d==null)
		{
			throw new Exception("No cab available!");
		}
		Customer c=customerRepository2.findById(customerId).get();
		tb.setCustomer(c);
		tb.setDriver(d);
		d.getCab().setAvailable(false);
		tb.setFromLocation(fromLocation);
		tb.setToLocation(toLocation);
		tb.setDistanceInKm(distanceInKm);
		int rate=d.getCab().getPerKmRate();
		tb.setBill(distanceInKm*10);
		tb.setStatus(TripStatus.CONFIRMED);
		c.getTripBookingList().add(tb);
		customerRepository2.save(c);
		d.getTripBookingList().add(tb);
		driverRepository2.save(d);
		return tb;
	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
         TripBooking b=tripBookingRepository2.findById(tripId).get();
         b.setStatus(TripStatus.CANCELED);
         b.setBill(0);
         b.getDriver().getCab().setAvailable(true);
         tripBookingRepository2.save(b);
         
	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking b=tripBookingRepository2.findById(tripId).get();
		 b.setStatus(TripStatus.COMPLETED);
		 int bill=b.getDriver().getCab().getPerKmRate()* (b.getDistanceInKm());
		 b.setBill(bill);
		 b.getDriver().getCab().setAvailable(true);
		 tripBookingRepository2.save(b);  		 
	}
}
