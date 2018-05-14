package com.ypachacama.gestion.model;

public class Department {
	
	
	String name;
	String city;
	String description;
	int department_id;
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String city, String description, int department_id) {
		super();
		this.name = name;
		this.city = city;
		this.description = description;
		this.department_id = department_id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", city=" + city + ", description=" + description + ", department_id="
				+ department_id + "]";
	}
	

}
