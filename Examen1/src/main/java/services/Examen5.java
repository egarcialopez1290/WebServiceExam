package services;

import java.sql.Date;

import javax.jws.WebMethod;

import dao.EmployedWorkedHoursDao;
import dao.EmployedWorkedHoursInt;
import dao.EmployeesDao;
import dao.EmployeesInt;
import model.EmployedWorkedHours;

public class Examen5 {
	@WebMethod
	public double totalPagoEmpleado ( EmployedWorkedHours empl, Date fecha1, Date fecha2 ) {
		EmployedWorkedHoursInt emplOph = new EmployedWorkedHoursDao();
		EmployeesInt emplOp = new EmployeesDao();
		
		double pago = 0;
		boolean existeEmpleado = emplOp.existeEmpleado(empl);
		
		if ( existeEmpleado == true ) {
			pago = emplOph.pagoDeEmpleado(empl, fecha1,fecha2);
		}
		
		return pago;
	}
}
