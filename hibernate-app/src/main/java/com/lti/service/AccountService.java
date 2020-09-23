package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.exception.AccountServiceException;

//service is a common naming convention for classes containing business logic
// seriously missing the atomicity feature.// no proper commit/rollback.
public class AccountService {
	
	public void openAccount(Account acc)
	{
			if(acc.getBal() >= 5000)
			{
				GenericDao dao = new GenericDao();
				dao.save(acc);
			}
			else
			{
				throw new AccountServiceException("Cannot open Account due to insufficient balance!");	
			}
	}
	
	public void withdraw(int acno, double amount)
	{
		GenericDao dao = new GenericDao();
		Account acc = dao.fetchById(Account.class, acno);
		if(acc !=null)
		{
			double balance = acc.getBal();
			if(amount < balance) // need to improve this condition
			{
				acc.setBal(balance - amount);
				dao.save(acc);
				
				Transaction tx = new Transaction();
				tx.setAmount(amount);
				tx.setDateAndTime(LocalDateTime.now());
				tx.setType("Withdraw");
				tx.setAccount(acc);
				dao.save(tx);
				
			}
			else {
			throw new AccountServiceException("Insufficient Balance!");
			}
		}
		else {
		throw new AccountServiceException("no such account exists");
		}
	}
	
	public void deposit (int acno, double amount)
	{
		GenericDao dao = new GenericDao();
		Account acc = dao.fetchById(Account.class, acno);
		if(acc !=null)
		{
			double balance = acc.getBal();
			
				acc.setBal(balance + amount);
				dao.save(acc);
				
				Transaction tx = new Transaction();
				tx.setAmount(amount);
				tx.setDateAndTime(LocalDateTime.now());
				tx.setType("Deposit");
				tx.setAccount(acc);
				dao.save(tx);
				
		}	
		else {
		throw new AccountServiceException("no such account exists");
		}
	}
	
	public void transfer(int fromAcno, int toAcno, double amount )
	{
		withdraw(fromAcno,amount);
		deposit(toAcno,amount);
	}
	
	public double balance(int acno)
	{
		GenericDao dao = new GenericDao();
		Account acc = dao.fetchById(Account.class, acno);
		if(acc != null)
		{
			return acc.getBal();
		}
		else
		{
			throw new AccountServiceException("no such account exists");
		}
		
	}
	
	public List<Transaction> miniStatement1(int acno)
	{
		AccountDao dao = new AccountDao();
		Transaction acc = dao.fetchById(Transaction.class, acno);
		if(acc!=null)
		{
			return dao.fetchMiniStatement(acno);
		}
		else
		{
			throw new AccountServiceException("no such account exists");
		}
		
		
	}
	
	public List<Transaction> miniStatement(int acno)
	{
		AccountDao dao = new AccountDao();
		if(dao.exists(acno))
			return dao.fetchMiniStatement(acno);
		else
			throw new AccountServiceException("no such account exists");
	}
	
	//return list of accounts in which a single transaction of more 
	//than 10 lac has been done.
	
	public List<Account> suspiciousCheck()
	{ AccountDao dao = new AccountDao();
	
		return dao.fetchSuspiciousAccount();
	
	}
}
