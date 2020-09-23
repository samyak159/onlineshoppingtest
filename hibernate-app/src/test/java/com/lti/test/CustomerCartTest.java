package com.lti.test;

import org.junit.Test;
import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.ShoppingCart;

public class CustomerCartTest
{

	@Test
	public void addCustomer()
	{
		Customer c = new Customer();
		c.setName("Sam");
		c.setEmail("sam@lti.com");
		
		GenericDao dao = new GenericDao();
		dao.save(c);
	}
	
	@Test
	public void addToCart()
	{
		//assuming we are adding a mobile phone 
		GenericDao dao = new GenericDao();
		Customer c = dao.fetchById(Customer.class, 27);
		double price = 10800;
		//check if there is a cart associated with this customer
		//if not then insert one record in cart for the customer
		//update the no. of items and the total
		ShoppingCart cart =  c.getShoppingcart();
		if(cart ==null)
		{
			cart = new ShoppingCart();
			cart.setCustomer(c);
			cart = dao.save(cart);
		}
		cart.setItems(cart.getItems()+1);
		cart.setTotal(cart.getTotal()+price);
		dao.save(cart);
		
	}
}
