package com.lti.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InsuranceId implements Serializable{

	private int insuranceNo;
	private String country;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + insuranceNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsuranceId other = (InsuranceId) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (insuranceNo != other.insuranceNo)
			return false;
		return true;
	}
	public int getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(int insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
