package com.lti.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Booking;
import com.lti.entity.Passenger;
import com.lti.entity.Passenger.Gender;

public class BookingTest {

	@Test
	public void doBooking()
	{
		Booking booking = new Booking();
		booking.setAmount(1000);
		booking.setBookingDate(LocalDate.now());
		
		List<Passenger> passengers  = new ArrayList<>();
		Passenger p1 = new Passenger();
		p1.setName("Samyak");
		p1.setGender(Gender.MALE);
		p1.setBooking(booking);
		
		Passenger p2 = new Passenger();
		p2.setName("Riya");
		p2.setGender(Gender.FEMALE);
		p2.setBooking(booking);
		
		passengers.add(p1);
		passengers.add(p2);
		
		booking.setPassengers(passengers);
		
		GenericDao dao = new GenericDao();
		dao.save(booking);
		
	}
	
	@Test
	public void fetchBooking() {
		GenericDao dao =  new GenericDao();
		Booking booking = dao.fetchById(Booking.class,101);
		System.out.println(booking.getAmount()+" "+ booking.getBookingDate());
		for(Passenger passenger: booking.getPassengers())
		{
			System.out.println(passenger.getName()+" "+passenger.getGender());
		}
	}
	
	@Test
	public void fetchPassenger()
	{
		GenericDao dao = new GenericDao();
		Passenger passenger = dao.fetchById(Passenger.class, 102);
		System.out.println(passenger.getName()+" "+passenger.getGender());
		Booking booking = passenger.getBooking();
		System.out.println(booking.getAmount()+" "+ booking.getBookingDate());
	}
	
}
