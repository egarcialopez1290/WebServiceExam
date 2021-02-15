package model;

import java.sql.Date;

public class Employees {
	private int id;
	private int genderId;
	private int jobId;
	private String name;
	private String lastName;
	private Date birthDate;

	public Employees(int id, int genderId, int jobId, String name, String lastName, Date birthDate) {
		this.id = id;
		this.genderId = genderId;
		this.jobId = jobId;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Employees() {
		this.id = 0;
		this.genderId = 0;
		this.jobId = 0;
		this.name = "";
		this.lastName = "";
		this.birthDate = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
