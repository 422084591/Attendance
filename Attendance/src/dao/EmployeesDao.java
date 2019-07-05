package dao;

import java.util.List;

public interface EmployeesDao<T> {
	public void addEmployees(T t); // 添加员工信息

	public void removeEmployeesByEmp_ids(int[] emp_ids); // 通过员工id数组批量删除员工信息

	public void deleteEmployeesByEmp_id(int emp_id); // 通过员工id删除员工信息

	public void updateEmployeesByEmp_id(int emp_id, T t); // 通过员工的id修改员工的信息
	public List<T> getAllEmployees(); // 查询所有员工的信息

	public T getEmployeeByEmp_id(int Emp_id); // 通过员工id来找员工信息

	public List<T> getEmployeeByStaffCode(String staffCode); // 通过员工编码获得员工对象

	public List<T> getEmployeeByName(String name); // 通过员工姓名查找员工

	public List<T> getAllByLimit(int limitNumber); // 每页找出的员工信息数量

	public int getMaxPage(); // 当前数据记录一共有几页
}
