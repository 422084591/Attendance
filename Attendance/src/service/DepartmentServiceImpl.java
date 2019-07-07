package service;

import java.util.List;

import dao.DepartmentDaoImpl;
import model.Department;

public class DepartmentServiceImpl implements DepartmentService<Department> {
	DepartmentDaoImpl dao=new DepartmentDaoImpl();

	@Override
	public boolean addDepartment(Department t) {// 增加部门信息
		// TODO Auto-generated method stub
		return dao.addDepartment(t);
	}

	@Override
	public boolean removeDepartmentByDepartmentIds(int[] departmentIds) {// 批量删除部门信息
		// TODO Auto-generated method stub
		return dao.removeDepartmentByDepartmentIds(departmentIds);
	}

	@Override
	public boolean deletaDepartmentByDempartmentId(int departmentId) {// 通过部门ID删除部门信息
		// TODO Auto-generated method stub
		return dao.deletaDepartmentByDempartmentId(departmentId);
	}

	@Override
	public boolean updateDepartmentByDepartmentId(int departmentId, Department t) {// 通过部门ID修改部门信息
		// TODO Auto-generated method stub
		return dao.updateDepartmentByDepartmentId(departmentId, t);
	}

	@Override
	public List<Department> getAllDepartmentInfo() {// 获得所有的部门信息
		// TODO Auto-generated method stub
		return dao.getAllDepartmentInfo();
	}

	@Override
	public Department getDepartmentByDepartmentID(int departmentID) {// 通过部门id来找部门信息
		// TODO Auto-generated method stub
		return dao.getDepartmentByDepartmentID(departmentID);
	}

	@Override
	public List<Department> getDepartmentByDepartmentCode(String departmentCode) {// 通过部门编码获得员工对象
		// TODO Auto-generated method stub
		return dao.getDepartmentByDepartmentCode(departmentCode);
	}

	@Override
	public List<Department> getDepartmentByDepartmentName(String dapartmentName) {// 通过部门名称查找员工
		// TODO Auto-generated method stub
		return dao.getDepartmentByDepartmentName(dapartmentName);
	}

	@Override
	public List<Department> getAllByLimit(int limitNumber) {// 每页找出的部门信息数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() { // 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}




}
