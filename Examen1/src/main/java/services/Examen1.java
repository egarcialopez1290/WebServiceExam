package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dao.EmployeesDao;
import dao.EmployeesInt;
import dao.GendersDao;
import dao.GendersInt;
import dao.JobsDao;
import dao.JobsInt;
import model.Employees;
import model.Genders;
import model.Jobs;

@WebService
public class Examen1 {
	@WebMethod
	public boolean newEmployeeService( Employees empl, Genders gen, Jobs jobs ) {
		EmployeesInt emploOp = new EmployeesDao();
		GendersInt genOp = new GendersDao();
		JobsInt jobsOp = new JobsDao();
		
		boolean respuesta = false;
		boolean existeName = emploOp.existeName(empl);
		boolean existeLast = emploOp.existeName(empl);
		boolean existeGender = genOp.existeGender(gen);
		boolean existeJob	= jobsOp.existeJob(jobs);
		
		// Si todas las condiciones son falsas, es decir: no existen registros
		if ( existeName==false && existeLast==false && existeGender==false && existeJob==false  ) {
			emploOp.nuevoEmployee(empl);
			respuesta = true;
		}
		
		return respuesta;
	}
}
