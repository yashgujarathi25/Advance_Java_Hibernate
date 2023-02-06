package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "emps_tbl")
public class Employee extends BaseEntity {
	
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	private String salary;
	@Column(length = 100)
	private String address;
	@Column(name="join_date")
	private LocalDate joinDate;
	//many to one uni dir asso Employee *---> 1Department
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department myDepartment;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String salary, String address, LocalDate joinDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
		this.joinDate = joinDate;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee ID = "+getId()+"[firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", address="
				+ address + ", joinDate=" + joinDate + "]";
	}
	
	
}
