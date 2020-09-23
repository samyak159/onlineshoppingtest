package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Order;

public class OrderTest
{
	@Test
	public void sequencetest()
	{
		GenericDao dao = new GenericDao();
		Order o = new Order();
		o.setAmount(2000);
		o.setOrderDate(LocalDate.now());
		dao.save(o);
	}
}
