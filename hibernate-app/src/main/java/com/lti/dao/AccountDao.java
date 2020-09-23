package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.Song;
import com.lti.entity.Transaction;

public class AccountDao extends GenericDao
{
	public List<Transaction> fetchMiniStatement(int acno)

	{
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	try
	{
	emf = Persistence.createEntityManagerFactory("hibernate-app");
	em = emf.createEntityManager();
	String jpql ="select t from Transaction t where t.account.acno = :acno order by t.dateAndTime desc ";
	Query q =em.createQuery(jpql);
	q.setParameter("acno", acno);
	q.setMaxResults(5);
	List<Transaction> list = q.getResultList();
	return list;
	}
	
	finally
	{
	em.close();
	emf.close();
    }
	}
	
	public boolean exists(int acno)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try
		{
		emf = Persistence.createEntityManagerFactory("hibernate-app");
		em = emf.createEntityManager();
		String jpql ="select count(a.acno) from Account a where a.acno = :acno";
		Query q =em.createQuery(jpql);
		q.setParameter("acno", acno);
		Long count = (Long) q.getSingleResult(); 
		List<Transaction> list = q.getResultList();
		if(count ==1)
			return true;
		else
			return false;
		}
		
		finally
		{
		em.close();
		emf.close();
	    }
	}
	
	public List<Account> fetchSuspiciousAccount()

	{
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	try
	{
	emf = Persistence.createEntityManagerFactory("hibernate-app");
	em = emf.createEntityManager();
	//select a.name, a.acno from tbl_tran t join tbl_acc a on a.acno = t.ac_id where t.amount>1000;
	String jpql ="select a from Transaction t join t.account a where t.amount>1000";
	Query q =em.createQuery(jpql);
	//q.setParameter("acno", acno);
	//q.setMaxResults(5);
	List<Account> list = q.getResultList();
	return list;
	}
	
	finally
	{
	em.close();
	emf.close();
    }
	}
}