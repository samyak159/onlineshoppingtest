package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_emp")
public class Employee {
	
	@Id
	@GeneratedValue
	private int psno;
	
	private String name;
	private LocalDate dateOfJoining;
	private double salary;
	
	//private int add_id;//never do this.
	// fk column should never be mentioned directly.
	
	@OneToOne(cascade =CascadeType.MERGE)
	@JoinColumn(name = "addr_id") //fk column
	private Address address; //has a relationship

	public int getPsno() {
		return psno;
	}

	public void setPsno(int psno) {
		this.psno = psno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
