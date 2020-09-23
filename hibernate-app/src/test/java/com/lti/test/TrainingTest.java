package com.lti.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.dao.StudentCourseDao;
import com.lti.entity.Address;
import com.lti.entity.Course;
import com.lti.entity.Employee;
import com.lti.entity.Enrollment;
import com.lti.entity.Student;

public class TrainingTest
{
	@Test
	public void addSomeStudents()
	{
		Student s = new Student();
		s.setName("Amit");
		s.setCity("Banglore");
		GenericDao dao = new GenericDao();
		dao.save(s);
	}
	
	@Test
	public void addSomeCourses()
	{
		GenericDao dao = new GenericDao();
		
		Course c2 = new Course();
		c2.setName("DotNet");
		c2.setDuration("2 months");
		dao.save(c2);
		
	}
	
	@Test
	public void enrollAsStudentsForSomeCourses()
	{
		GenericDao dao = new GenericDao();
		Student s = dao.fetchById(Student.class, 78); //72,78,81,80,82
		Course c = dao.fetchById(Course.class, 83); //74,83
		
		Enrollment e = new Enrollment();
		//Enrollment.Id id = new Enrollment.Id();
		e.setStudent(s);
		e.setCourse(c);
		//e.setId(id);
		e.setEnrollmentDate(LocalDate.now());
		dao.save(e);
		
	}
	
	@Test
	public void fetchStudentsEnrolledInJava()
	{
		StudentCourseDao dao = new StudentCourseDao();
		List<Student> list = dao.fetchStudentsByCourse("Java");
		for(Student s : list)
		{
			System.out.println(s.getName()+ "\t" +s.getCity());
		}
	}
}
