package com.testingAPI.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Persons")
public class Persons {
	
	@Id
	@Column(length = 3)
	private int id;
	@Column(length = 30)
	private String name;
	@Column(length = 10)
	private int salary;
	@Column(length = 20)
	private String place;
	
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	@Override
	public String toString() {
		return "Persons [id=" + id + ", name=" + name + ", salary=" + salary + ", place=" + place + "]";
	}
}