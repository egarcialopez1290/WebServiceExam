package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dao.EmployedWorkedHoursDao;
import dao.EmployedWorkedHoursInt;
import dao.EmployeesDao;
import dao.EmployeesInt;
import model.EmployedWorkedHours;

@WebService
public class Examen4 {
	@WebMethod
	public int totalHorasTrabajadas ( EmployedWorkedHours empl ) {
		EmployedWorkedHoursInt emplOph = new EmployedWorkedHoursDao();
		EmployeesInt emplOp = new EmployeesDao();
		
		int horas = 0;
		boolean existeEmpleado = emplOp.existeEmpleado(empl);
		
		if ( existeEmpleado == true ) {
			horas = emplOph.horasTrabajadas(empl);
		}
		
		return horas;
	}
}
