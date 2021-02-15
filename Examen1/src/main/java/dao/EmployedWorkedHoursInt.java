package dao;

import java.sql.Date;

import model.EmployedWorkedHours;

public interface EmployedWorkedHoursInt {
	public double pagoDeEmpleado ( EmployedWorkedHours empl, Date fecha1, Date fecha2 );
	public int horasTrabajadas ( EmployedWorkedHours empl );
	public boolean superaLimiteHorasTrabajadas( EmployedWorkedHours empl );
	public boolean fechaLimite ( EmployedWorkedHours empl );
	public boolean existeRegistroHoy (EmployedWorkedHours empl);
	public void nuevoRegistro (EmployedWorkedHours empl);
}
