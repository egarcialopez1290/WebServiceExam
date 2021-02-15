package dao;

import java.util.List;

import model.EmployedWorkedHours;
import model.Employees;
import model.Jobs;

public interface EmployeesInt {
	public void nuevoEmployee ( Employees empl );
	public boolean existeName (Employees empl);
	public boolean existeLastName (Employees empl);
	public boolean existeEmpleado (EmployedWorkedHours empl);
	public List consultaEmpleadosPorJob( Jobs jobs );
}
