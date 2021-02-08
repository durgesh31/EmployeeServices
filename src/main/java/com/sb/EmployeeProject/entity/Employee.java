package com.sb.EmployeeProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="employee_information")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="first_name")
	@NotNull(message="First Name is required.")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message="Last Name is required.")
	private String lastName;
	
	@Column(name="email_id")
	@NotNull(message="Email is mandatory.")
	private String emailId;
	
	@Column(name="age")
	@NotNull(message="Age is required field.")
	private int age;
	
	@Column(name="gender")		
	private String gender;
	
	@Column(name="address")
	private String address;

	
	@Column(name="operational_status")
	@NotNull(message="operationalStatus is mandatory for the employee.")
	private String OperationalStatus;
	
	
	public Employee() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public String getOperationalStatus() {
		return OperationalStatus;
	}

	public void setOperationalStatus(String operationalStatus) {
		OperationalStatus = operationalStatus;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
	}
	
	
}
