package com.microservices.reactivemongo.model;

import java.util.Date;

public class EmployeeEvent{

	public EmployeeEvent(Employee employee, Date date) {
		super();
		this.employee = employee;
		this.date = date;
	}

	private Employee employee;
	
	private Date date;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
