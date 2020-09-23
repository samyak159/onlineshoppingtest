package com.lti.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Insurance {
	
	//private int insuranceNo;
	//private String country;
	@EmbeddedId // composite-pk
	private InsuranceId id;
	
	private double coverage;
	private double premium;
	public InsuranceId getId() {
		return id;
	}
	public void setId(InsuranceId id) {
		this.id = id;
	}
	public double getCoverage() {
		return coverage;
	}
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	

}
