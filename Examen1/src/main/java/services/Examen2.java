package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dao.EmployedWorkedHoursDao;
import dao.EmployedWorkedHoursInt;
import dao.EmployeesDao;
import dao.EmployeesInt;
import model.EmployedWorkedHours;

@WebService
public class Examen2 {
	@WebMethod
	public boolean newUpHours ( EmployedWorkedHours empl ) {
		EmployedWorkedHoursInt emplOph = new EmployedWorkedHoursDao();
		EmployeesInt emplOp = new EmployeesDao();
		
		boolean respuesta = false;
		boolean existeEmpleado = emplOp.existeEmpleado(empl);
		boolean limiteHoras = emplOph.superaLimiteHorasTrabajadas(empl);
		boolean fechaMenor = emplOph.fechaLimite(empl);
		boolean existeRegistro = emplOph.existeRegistroHoy(empl);
		
		if ( existeEmpleado==true && limiteHoras==false && fechaMenor==true && existeRegistro==false ) {
			emplOph.nuevoRegistro(empl);
		}
		
		return respuesta;
	}
}
