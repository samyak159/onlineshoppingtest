package com.lti.test;
import java.time.LocalDate;
import org.junit.Test;
import com.lti.dao.GenericDao;
import com.lti.entity.Address;
import com.lti.entity.Employee;

public class EmployeeAddressTest
{

	@Test
	public void addEmployee()
	{
		Employee emp = new Employee();
		emp.setName("Samyak");
		emp.setDateOfJoining(LocalDate.of(2020, 07, 25));
		emp.setSalary(10000);
		
		GenericDao dao = new GenericDao();
		dao.save(emp);
	}
	
	@Test
	public void addAddressForAnExistingEmployee()
	{
		GenericDao dao = new GenericDao();
		Employee emp = dao.fetchById(Employee.class, 6); // check psno in db
		
		Address addr = new Address();
		addr.setCity("Rourkela");
		addr.setPincode(769005);
		addr.setLandmark("Near Rourkela House");
		
		addr = dao.save(addr);
		emp.setAddress(addr);
		dao.save(emp);
	}
	
	@Test
	public void addEmployeeAlongWithAddress()
	{
		GenericDao dao = new GenericDao();
		Employee e = new Employee();
		e.setName("Gul Umar");
		e.setDateOfJoining(LocalDate.now());
		e.setSalary(21000);
		
		Address addr = new Address();
		addr.setCity("Bhopal");
		addr.setPincode(765019);
		addr.setLandmark("Kantat");
		
	    e.setAddress(addr);
		dao.save(e);
	
	}
	
}
