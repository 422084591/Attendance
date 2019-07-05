package service;

import java.util.List;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import model.Employees;

public class EmployeesServiceImpl implements EmployeesService<Employees> {
	EmployeesDaoImpl dao=new EmployeesDaoImpl();

	@Override
	public void addEmployees(Employees t) {
		// TODO Auto-generated method stub
		dao.addEmployees(t);
	}

	@Override
	public void removeEmployeesByEmp_ids(int[] emp_ids) {
		// TODO Auto-generated method stub
		dao.removeEmployeesByEmp_ids(emp_ids);
	}

	@Override
	public void deleteEmployeesByEmp_id(int emp_id) {
		// TODO Auto-generated method stub
		dao.deleteEmployeesByEmp_id(emp_id);
	}

	@Override
	public void updateEmployeesByEmp_id(int emp_id, Employees t) {
		// TODO Auto-generated method stub
		dao.updateEmployeesByEmp_id(emp_id, t);
	}


	@Override
	public Employees getEmployeeByEmp_id(int Emp_id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByEmp_id(Emp_id);
	}

	@Override
	public List<Employees> getEmployeeByStaffCode(String staffCode) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByStaffCode(staffCode);
	}

	@Override
	public List<Employees> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByName(name);
	}

	@Override
	public List<Employees> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}


	


}
