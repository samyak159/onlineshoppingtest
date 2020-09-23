package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.User;

//classes which contain DB interaction code
//commonly reffered to as data access object

public class UserDao
{

	public void store(User user)
	{
		//Step 1. Create/Obtain EntityManagerfactory Object
		//During this step META-INF/persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");//<persistent-unit name=".."
		//Step 2. Create/Obtain EntityManager Object
		EntityManager em = emf.createEntityManager();
		//Step 3.Start/Participate in a Transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can perform any insert/update/delete/select SQL operation
		//em.persist(user);//persist method generates insert query --> insert into table table_name(?,?,?,?,?)
		em.merge(user);//can be used for modify and insert both
		tx.commit();
		
		//should be in finally block
			em.close();
			emf.close();
	}
	
	public User retrieve(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		User u = em.find(User.class, id);
		em.close();
		emf.close();
		
		return u; 	 	
		
	}
	
	public List<User> retrieve(String name)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		
		//SQL -> select u.* from tbl_user u where u.name like '%a%'
		String jpql ="select u from User u where u.name like :ul ";//:nm -> placeholder
		Query q =em.createQuery(jpql);
		q.setParameter("ul", "%" + name+ "%");
		List<User> list = q.getResultList();
		
		em.close();
		emf.close();
		return list;

	}
	
	//retrieve all the users whose date of birth falls in the given month
	//first write the SQl and practice it seperately using SQLDeveloper
	//then try writing the JPQL for the same.
	public List<User> retrieveByBirthDate(int month)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		
		//SQL -> select u.* from tbl_user u where u.name like '%a%'
		String jpql ="select u from User u where month(u.dateOfBirth) = :mon ";//internally using extract function
		Query q =em.createQuery(jpql);
		q.setParameter("mon",month);
		List<User> list = q.getResultList();
		
		em.close();
		emf.close();
		return list;

	}
}
