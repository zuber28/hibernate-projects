package com.mikadosolutions.training.hibernate.onetoonexml;

import java.io.Serializable;
import java.util.Map;
import java.util.SortedMap;

public class Employee implements Serializable
{
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private MCertificate certificate;
	
	public Employee()
	{
		
	}
	
	public Employee(String fname, String lname, double salary)
	{
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}
	
	public Employee(String fname, String lname, double salary, MCertificate certificates)
	{
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
		this.certificate = certificates;
	}

	public MCertificate getCertificate() 
	{
		return certificate;
	}

	public void setCertificate(MCertificate certificate) 
	{
		this.certificate = certificate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
			return false;
		if (id == 0)
			return false;
		if (o instanceof Employee)
		{
			return ((Employee)o).getId() == this.id;
		}
		else
			return false;
	}
	
	public String toString()
	{
		return "\nid = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", salary = " + salary
				+ ",\nCertificates = " + certificate;
	}
}
