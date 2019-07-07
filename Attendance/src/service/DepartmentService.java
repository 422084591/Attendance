package service;

import java.util.List;

public interface DepartmentService<T> {
	public boolean addDepartment(T t); // 增加部门信息

	public boolean removeDepartmentByDepartmentIds(int[] departmentIds); // 批量删除部门信息

	public boolean deletaDepartmentByDempartmentId(int departmentId); // 通过部门ID删除部门信息

	public boolean updateDepartmentByDepartmentId(int departmentId, T t); // 通过部门ID修改部门信息

	public List<T> getAllDepartmentInfo(); // 获得所有的部门信息

	public T getDepartmentByDepartmentID(int departmentID); // 通过部门id来找部门信息

	public List<T> getDepartmentByDepartmentCode(String departmentCode); // 通过部门编码获得员工对象

	public List<T> getDepartmentByDepartmentName(String dapartmentName); // 通过部门名称查找员工

	public List<T> getAllByLimit(int limitNumber); // 每页找出的部门信息数量

	public int getMaxPage(); // 当前数据记录一共有几页
}
