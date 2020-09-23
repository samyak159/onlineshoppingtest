package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.lti.entity.Student;

public class StudentCourseDao extends GenericDao
{
	public List<Student> fetchStudentsByCourse(String course)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try
		{
		emf = Persistence.createEntityManagerFactory("hibernate-app");
		em = emf.createEntityManager();
        //select s.name, s.city from tbl_stud s join tbl_enroll e on s.id = e.student_id join tbl_course c on c.id = e.course_id
		//where c.name='Java';
		//String jpql ="select s from Student s join s.enrollments e join e.course c where c.name = :course";
		String jpql ="select s from Student s join s.enrollments e where e.course.name =:course";
		Query q =em.createQuery(jpql);
		q.setParameter("course", course);
		List<Student> list = q.getResultList();
		return list;
		}
		finally
		{
		em.close();
		emf.close();
		}
	}
}
