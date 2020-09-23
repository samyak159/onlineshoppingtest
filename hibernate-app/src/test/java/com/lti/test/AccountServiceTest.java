package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.exception.AccountServiceException;
import com.lti.service.AccountService;


public class AccountServiceTest
{
	//positive-testing - should work
	@Test
	public void checkOpenAccount()
	{
		//GenericDao dao = new GenericDao();
		Account acc = new Account();
		acc.setName("Samyak");
		acc.setType("Savings");
		acc.setBal(5000);
		
		AccountService accServ = new AccountService();
		accServ.openAccount(acc);
	}
	
	//negative-testing - shouldnt work
		@Test(expected = AccountServiceException.class)
		public void checkOpenAccount1()
		{
			//GenericDao dao = new GenericDao();
			Account acc = new Account();
			acc.setName("Samyak");
			acc.setType("Savings");
			acc.setBal(4000);
			AccountService accServ = new AccountService();
			accServ.openAccount(acc);
		}
		
		@Test
		public void withdraw()
		{
			AccountService accServ = new AccountService();
			accServ.withdraw(64, 1000);
		}
		
		@Test
		public void deposit()
		{
			AccountService accServ = new AccountService();
			accServ.deposit(63, 2000);
		}
		
		@Test
		public void balance()
		{
			AccountService accServ = new AccountService();
			accServ.balance(63);
		}
		
		@Test
		public void transfer()
		{
			AccountService accServ = new AccountService();
			accServ.transfer(63,64,1000);
		}
		
		@Test
		public void miniStatement()
		{
			AccountService accServ = new AccountService();
			List<Transaction> list =accServ.miniStatement(63);
			for(Transaction t:list)
			{
				System.out.println(t.getTxno()+"\t"+t.getDateAndTime()
				+t.getAmount()+t.getType());
			}
		}
		
		@Test
		public void checksuspicious()
		{
			AccountService accServ = new AccountService();
			List<Account> list = accServ.suspiciousCheck();
			for(Account a : list)
			{
				System.out.println(a.getAcno());
			}
		}
		
		


	
	
}
