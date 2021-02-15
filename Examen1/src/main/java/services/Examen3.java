package services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dao.EmployeesDao;
import dao.EmployeesInt;
import dao.JobsDao;
import dao.JobsInt;
import model.Jobs;

@WebService
public class Examen3 {
	@WebMethod
	public List consultaEmpleadosPorJob ( Jobs jobs ) {
		List empleadosList = null;
		EmployeesInt emplOp = new EmployeesDao();
		JobsInt jobsOp = new JobsDao();
		
		boolean existeJob = jobsOp.existeJob(jobs);
		if ( existeJob == true ) {
			empleadosList = emplOp.consultaEmpleadosPorJob(jobs);
		}
		
		return empleadosList ;
	}
}
