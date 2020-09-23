package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.GenericDao;

import com.lti.entity.Passport;
import com.lti.entity.Person;

public class PersonPassportTest
{
	@Test
	public void addPerson()
	{
		Person per = new Person();
		per.setName("Samyak");
		per.setDob(LocalDate.now());
		per.setCity("Delhi");
		
		GenericDao dao = new GenericDao();
		dao.save(per);
	}
	
	@Test
	public void addPassportOfExistingPerson()
	{
		GenericDao dao = new GenericDao();
		Person per = dao.fetchById(Person.class,1);
		
		Passport pas = new Passport();
		pas.setIssueDate(LocalDate.of(2000, 01, 15));
		pas.setExpiryDate(LocalDate.of(2002, 02, 14));
		pas.setAuthority("Mumbai");
		
		pas = dao.save(pas);
		per.setPassport(pas);
		dao.save(per);
	}
	
	@Test
	public void addPersonAlongWithPassport()
	{
		GenericDao dao = new GenericDao();
		Person per = new Person();
		per.setName("Samyak");
		per.setDob(LocalDate.now());
		per.setCity("Delhi");
		
		Passport pas = new Passport();
		pas.setIssueDate(LocalDate.of(2000, 01, 15));
		pas.setExpiryDate(LocalDate.of(2002, 02, 14));
		pas.setAuthority("Mumbai");
		
	    per.setPassport(pas);
		dao.save(per);
	}

}
