package com.lti.test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.lti.dao.DeptEmpDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Dept;
import com.lti.entity.Emp;
import com.lti.entity.Song;

public class DeptEmpTest
{
	@Test
	public void addDeptAlongWithEmp()
	{
		DeptEmpDao dao = new DeptEmpDao();
		Dept dp = new Dept();
		dp.setName("Management");
		dp.setLocation("Chennai");
		
		List<Emp> employees = new ArrayList<>();
		Emp e1 = new Emp();
		e1.setName("Rahul");
		e1.setSalary(20000);
		e1.setDept(dp);
		employees.add(e1);
		
		dp.setEmployees(employees);
		dao.save(dp);

	}
}
