package service;

import java.util.List;

import dao.DepartmentDaoImpl;
import model.Department;

public class DepartmentServiceImpl implements DepartmentService<Department> {
	DepartmentDaoImpl dao=new DepartmentDaoImpl();

	@Override
	public boolean addDepartment(Department t) {
		// TODO Auto-generated method stub
		return dao.addDepartment(t);
	}

	@Override
	public boolean removeDepartmentByDepartmentIds(int[] departmentIds) {
		// TODO Auto-generated method stub
		return dao.removeDepartmentByDepartmentIds(departmentIds);
	}

	@Override
	public boolean deletaDepartmentByDempartmentId(int departmentId) {
		// TODO Auto-generated method stub
		return dao.deletaDepartmentByDempartmentId(departmentId);
	}

	@Override
	public boolean updateDepartmentByDepartmentId(int departmentId, Department t) {
		// TODO Auto-generated method stub
		return dao.updateDepartmentByDepartmentId(departmentId, t);
	}

	@Override
	public List<Department> getAllDepartmentInfo() {
		// TODO Auto-generated method stub
		return dao.getAllDepartmentInfo();
	}

	@Override
	public Department getDepartmentByDepartmentID(int departmentID) {
		// TODO Auto-generated method stub
		return dao.getDepartmentByDepartmentID(departmentID);
	}

	@Override
	public List<Department> getDepartmentByDepartmentCode(String departmentCode) {
		// TODO Auto-generated method stub
		return dao.getDepartmentByDepartmentCode(departmentCode);
	}

	@Override
	public List<Department> getDepartmentByDepartmentName(String dapartmentName) {
		// TODO Auto-generated method stub
		return dao.getDepartmentByDepartmentName(dapartmentName);
	}

	@Override
	public List<Department> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}




}
