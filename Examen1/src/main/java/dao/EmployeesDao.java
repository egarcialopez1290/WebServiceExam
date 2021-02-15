package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import model.EmployedWorkedHours;
import model.Employees;
import model.Jobs;

public class EmployeesDao extends DataSourceOptions implements EmployeesInt{
	
	public List consultaEmpleadosPorJob( Jobs jobs ) {
		String sql = "SELECT EMPLOYEES.ID,EMPLOYEES.JOB_ID,EMPLOYEES.NAME,EMPLOYEES.LAST_NAME,EMPLOYEES.BIRTHDATE FROM EMPLOYEES,GENDERS "
				+ "WHERE GENDERS.NAME=? AND EMPLOYEES.GENDER_ID=GENDERS.ID";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		List<Employees> empleadosLista = null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,jobs.getName());
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Employees empleado = new Employees(); 
				
				List empleados = null;
				
				empleado.setId(rs.getInt(1));
				empleado.setJobId(rs.getInt(2));
				empleado.setName(rs.getString(3));
				empleado.setLastName(rs.getString(4));
				empleado.setBirthDate(rs.getDate(5));
				
				empleadosLista.add(empleado);
			}
			
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return empleadosLista;
	}
	
	public boolean existeEmpleado (EmployedWorkedHours empl) {
		String sql = "SELECT COUNT(id) from employees WHERE id=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean existe = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getEmployeeId());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			
			if ( rs.next() ) {
				count = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( count == 0 ) {
				existe = false;
			}
			else {
				existe = true;
			}
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return existe;
	}
	
	
	public void nuevoEmployee ( Employees empl ) {
		String sql = "INSERT INTO employees (GENDER_ID,JOB_ID,NAME,LAST_NAME,BIRTHDATE) VALUES(?,?,?,?,?)";
		Connection con = null;
		DataSource dataSource = this.getDataSource();

		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getGenderId());
			ps.setInt(2, empl.getJobId());
			ps.setString(3, empl.getName());
			ps.setString(4, empl.getLastName());
			ps.setDate(5, empl.getBirthDate());
			ps.executeQuery();
			
			ps.close();
			con.close();
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
	}
	
	public boolean existeName (Employees empl) {
		String sql = "SELECT COUNT(name) from employees WHERE name=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean respuesta = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empl.getName());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			
			if ( rs.next() ) {
				count = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( count == 0 ) {
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
	
	public boolean existeLastName (Employees empl) {
		String sql = "SELECT COUNT(last_name) from employees WHERE last_name=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean respuesta = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empl.getLastName());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			
			if ( rs.next() ) {
				count = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( count == 0 ) {
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
