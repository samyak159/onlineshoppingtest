package com.lti.test;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import com.lti.dao.UserDao;
import com.lti.entity.User;

public class UserDaoTest
{
   @Test
   public void addUser()
   {
	   User u = new User();
	   u.setId(200);
	   u.setName("mama");
	   u.setEmail("Mama@gmail.com");
	   u.setPassword("343557639");
	   u.setMobileNo(343465757);
	   u.setDateOfBirth(LocalDate.of(1980, 07, 27));
	   
	   UserDao dao = new UserDao();
	   dao.store(u);
   }
   
   @Test
   public void fetchUser()
   {
	   UserDao dao= new UserDao();
	   User u = dao.retrieve(1001);
	   System.out.println(u.getName()+ "\t"+ u.getEmail());
   }
   
   @Test
   public void updateUser()
   {
	   UserDao dao= new UserDao();
	   User u = dao.retrieve(123);
	   u.setEmail("majrul@yahoo.in");
	   dao.store(u);
   }
   
   @Test
   public void fetchUsers()
   {
	   UserDao dao= new UserDao();
	   List<User> list = dao.retrieveByBirthDate(10);
	   for(User u: list)
	   {
		   System.out.println(u.getName()+ "\t" + u.getMobileNo());
	   }
   }
}
