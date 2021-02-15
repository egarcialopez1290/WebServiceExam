package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.EmployedWorkedHours;

public class EmployedWorkedHoursDao extends DataSourceOptions implements EmployedWorkedHoursInt {
	public double pagoDeEmpleado ( EmployedWorkedHours empl, Date fecha1, Date fecha2 ) {
		String sql = "SELECT SUM( JOBS.SALARY ) FROM JOBS,EMPLOYEES,EMPLOYEE_WORKED_HOURS "
				+ "WHERE JOBS.ID=EMPLOYEES.JOB_ID AND EMPLOYEES.ID=EMPLOYEE_WORKED_HOURS.EMPLOYEE_ID"
				+ "AND EMPLOYEE_WORKED_HOURS.WORKED_DATE BETWEEN ? and ?"
				+ "AND EMPLOYEES.ID =?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		double respuesta = 0;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, fecha1);
			ps.setDate(2, fecha2);
			ps.setInt(3, empl.getEmployeeId());
			ResultSet rs = ps.executeQuery();
			double sum = 0;
			
			if ( rs.next() ) {
				sum = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			respuesta = sum;
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return respuesta;
	}
	
	public int horasTrabajadas ( EmployedWorkedHours empl ) {
		String sql = "SELECT SUM( worked_hours ) FROM EMPLOYEE_WORKED_HOURS WHERE employee_id=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		int respuesta = 0;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getEmployeeId());
			ResultSet rs = ps.executeQuery();
			int sum = 0;
			
			if ( rs.next() ) {
				sum = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			respuesta = sum;
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return respuesta;
	}
	
	public void nuevoRegistro (EmployedWorkedHours empl) {
		String sql = "INSERT INTO EMPLOYEE_WORKED_HOURS( EMPLOYEE_ID,WORKED_HOURS,WORKED_DATE ) VALUES(?,?,?) ";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getEmployeeId());
			ps.setInt(2, empl.getWorkedHours());
			ps.setDate(3, empl.getWorkedDate());
			ps.executeQuery();
			
			ps.close();
			con.close();
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
	}
	
	@Override
	public boolean superaLimiteHorasTrabajadas(EmployedWorkedHours empl) {
		String sql = "SELECT SUM( worked_hours ) FROM EMPLOYEE_WORKED_HOURS WHERE employee_id=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean respuesta = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getEmployeeId());
			ResultSet rs = ps.executeQuery();
			int sum = 0;
			
			if ( rs.next() ) {
				sum = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( sum <= 20 ) {
				respuesta = false;
			}
			else {
				respuesta = true;
			}
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return respuesta;
	}

	@Override
	public boolean fechaLimite(EmployedWorkedHours empl) {
		String sql = "SELECT WORKED_DATE FROM EMPLOYEE_WORKED_HOURS WHERE employee_id=? ORDER BY ID DESC LIMIT 1";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean respuesta = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getEmployeeId());
			ResultSet rs = ps.executeQuery();
			Date date = null;
			
			if ( rs.next() ) {
				date = rs.getDate(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( date.before(empl.getWorkedDate())  ) {
				respuesta = false;
			}
			else {
				respuesta = true;
			}
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return respuesta;
	}

	@Override
	public boolean existeRegistroHoy(EmployedWorkedHours empl) {
		String sql = "SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEE_WORKED_HOURS WHERE EMPLOYEE_ID=? and WORKED_DATE=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean respuesta = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getEmployeeId());
			ps.setDate(2, empl.getWorkedDate());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			
			if ( rs.next() ) {
				count = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( count <= 0 ) {
				respuesta = false;
			}
			else {
				respuesta = true;
			}
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		
		return respuesta;
	}
	
}









