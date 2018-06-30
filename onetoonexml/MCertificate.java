package com.mikadosolutions.training.hibernate.onetoonexml;

public class MCertificate implements Comparable<MCertificate>
{
	private int id;
	private String name;
	private Employee employee;
	
	public MCertificate()
	{
		
	}
	
	public MCertificate(String name)
	{
		this.name = name;
	}
	
	public MCertificate(String name, Employee employee)
	{
		this.name = name;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
			return false;
		if (o instanceof MCertificate)
		{
			return ((((MCertificate)o).getId()== this.id) && (((MCertificate)o).getName().equals(name)));
		}
		else
		{
			return false;
		}
	}
	
	public int hashCode()
	{
		return id;
	}
	
	public String toString()
	{
		return "id = " + id + " name = " + name;
	}
	
	public int compareTo(MCertificate certificate)
	{
		return name.compareTo(certificate.getName());
	}
}