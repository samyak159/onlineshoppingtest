package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Insurance;
import com.lti.entity.InsuranceId;
import com.lti.entity.Song;

public class InsuranceTest {
	
	@Test
	public void addInsurance()
	{
		Insurance in = new Insurance();
		InsuranceId inid = new InsuranceId();
		inid.setCountry("India");
		inid.setInsuranceNo(102);
		in.setId(inid);
		in.setCoverage(2000000);
		in.setPremium(1000);
		GenericDao dao = new GenericDao();
		dao.save(in);
	}
	
	@Test
	public void fetchInsurance()
	{
		GenericDao dao = new GenericDao();
		InsuranceId inid = new InsuranceId();
		inid.setCountry("India");
		inid.setInsuranceNo(102);
		Insurance in = dao.fetchById(Insurance.class, inid);
		System.out.println(in.getCoverage()+" "+in.getPremium());
		
	}

}
