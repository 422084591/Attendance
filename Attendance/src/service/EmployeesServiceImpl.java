package service;

import java.util.List;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import model.Employees;

public class EmployeesServiceImpl implements EmployeesService<Employees> {
	EmployeesDaoImpl dao = new EmployeesDaoImpl();

	@Override
	public void addEmployees(Employees t) {// 添加员工信息
		// TODO Auto-generated method stub
		dao.addEmployees(t);
	}

	@Override
	public void removeEmployeesByEmp_ids(int[] emp_ids) {// 通过员工id数组批量删除员工信息
		// TODO Auto-generated method stub
		dao.removeEmployeesByEmp_ids(emp_ids);
	}

	@Override
	public void deleteEmployeesByEmp_id(int emp_id) {// 通过员工id删除员工信息
		// TODO Auto-generated method stub
		dao.deleteEmployeesByEmp_id(emp_id);
	}

	@Override
	public void updateEmployeesByEmp_id(int emp_id, Employees t) {// 通过员工的id修改员工的信息
		// TODO Auto-generated method stub
		dao.updateEmployeesByEmp_id(emp_id, t);
	}

	@Override
	public Employees getEmployeeByEmp_id(int Emp_id) {// 通过员工id来找员工信息
		// TODO Auto-generated method stub
		return dao.getEmployeeByEmp_id(Emp_id);
	}

	@Override
	public List<Employees> getEmployeeByName(String name) {// 通过员工姓名查找员工
		// TODO Auto-generated method stub
		return dao.getEmployeeByName(name);
	}

	@Override
	public List<Employees> getAllByLimit(int limitNumber) {// 每页找出的员工信息数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<Employees> getAllEmployees() {// 查询所有员工的信息
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

}
