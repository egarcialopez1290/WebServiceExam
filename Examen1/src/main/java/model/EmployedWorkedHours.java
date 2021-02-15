package model;

import java.sql.Date;

public class EmployedWorkedHours {
	private int id;
	private int employeeId;
	private int workedHours;
	private Date workedDate;

	public EmployedWorkedHours(int id, int employeeId, int workedHours, Date workedDate) {
		this.id = id;
		this.employeeId = employeeId;
		this.workedHours = workedHours;
		this.workedDate = workedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public Date getWorkedDate() {
		return workedDate;
	}

	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}

}
