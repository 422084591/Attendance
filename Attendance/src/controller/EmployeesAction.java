package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.Employees;
import model.PageCount;
import model.Station;
import service.EmployeesServiceImpl;
import service.StationServiceImpl;
import util.ExcelExportUtil;

public class EmployeesAction {
	StationServiceImpl service_S = new StationServiceImpl();
	EmployeesServiceImpl service = new EmployeesServiceImpl();
	private int emp_id;
	private String staffCode; // 员工编码
	private String name; // 姓名
	private String sex; // 性别(枚举,下拉框)
	private int age;// 年龄
	private String nation;// 民族
	private String idNumber;// 身份证
	private String salary;// 薪水
	private String phone;// 联系电话
	private String emergencyContact;// 紧急联系人
	private String emergencyContactNumber;// 紧急联系人电话
	private int stationId;// 岗位ID(用来查询岗位)
	private String individualDescription;// 个人描述
	ExcelExportUtil excel = new ExcelExportUtil();

	// 新的属性
	private List<Employees> employeesList = new ArrayList<Employees>();
	private Employees employee = new Employees();
	private int[] emp_ids;
	private String searchName;
	private int maxPage;
	private int minPage;
	private int currentPage = -1;
	private PageCount pageCount = PageCount.getInstance();
	// =======================
	private String stationName;// 岗位名称
	private String stationCode;// 岗位编码
	private List<Station> stationList = new ArrayList<Station>();
	private Station station = new Station();

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMinPage() {
		return minPage;
	}

	public void setMinPage(int minPage) {
		this.minPage = minPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public PageCount getPageCount() {
		return pageCount;
	}

	public void setPageCount(PageCount pageCount) {
		this.pageCount = pageCount;
	}

	public int[] getEmp_ids() {
		return emp_ids;
	}

	public void setEmp_ids(int[] emp_ids) {
		this.emp_ids = emp_ids;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public List<Employees> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employees> employeesList) {
		employeesList = employeesList;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public int getStationId() {
		return stationId;
	}

	public String getIndividualDescription() {
		return individualDescription;
	}

	public void setIndividualDescription(String individualDescription) {
		this.individualDescription = individualDescription;
	}

	/*-----------------------------------------------------------------------------------------------*/
	public String add() {
		employee.setEmp_id(emp_id);
		employee.setStaffCode(staffCode);
		employee.setName(name);
		employee.setSex(sex);
		employee.setAge(age);
		employee.setNation(nation);
		employee.setIdNumber(idNumber);
		employee.setSalary(salary);
		employee.setPhone(phone);
		employee.setStationId(stationId);
		employee.setEmergencyContact(emergencyContact);
		employee.setEmergencyContactNumber(emergencyContactNumber);
		employee.setIndividualDescription(individualDescription);
		service.addEmployees(employee);
		pageCount.setMaxPage(service.getMaxPage()); // 获取当前记录的页码
		pageCount.setCurrentPage(pageCount.getMaxPage());// 添加记录后自动跳转到最后一页
		return "add";
	}

	public String delete() {
		currentPage = pageCount.getCurrentPage(); // 删除完回到之前的页码
		service.deleteEmployeesByEmp_id(emp_id);
		return "delete";
	}

	public String remove() {
		currentPage = pageCount.getCurrentPage(); // 删除完保持之前的页码
		service.removeEmployeesByEmp_ids(emp_ids);
		return "remove";
	}

	public String edit() {
		employee = service.getEmployeeByEmp_id(emp_id);
		stationList = service_S.getAllStations();
		currentPage = pageCount.getCurrentPage(); // 编辑完保持之前的页码
		return "edit";
	}

	public String update() {
		employee.setEmp_id(emp_id);
		employee.setStaffCode(staffCode);
		employee.setName(name);
		employee.setSex(sex);
		employee.setAge(age);
		employee.setNation(nation);
		employee.setIdNumber(idNumber);
		employee.setSalary(salary);
		employee.setPhone(phone);
		employee.setStationId(stationId);
		employee.setEmergencyContact(emergencyContact);
		employee.setEmergencyContactNumber(emergencyContactNumber);
		employee.setIndividualDescription(individualDescription);
		service.updateEmployeesByEmp_id(emp_id, employee);
		currentPage = pageCount.getCurrentPage(); // 更新完保持之前的页码
		return "update";
	}

	public String limit() {
		pageCount.setMaxPage(service.getMaxPage()); // 获取记录的页数，每次检测，防治删除数据后页码减少或者添加数据后页码增加
		if (currentPage != -1) {
			if (currentPage > pageCount.getMaxPage()) {
				currentPage = pageCount.getMaxPage(); // 如果当前页码大于等于最大页码的话，让当前页码等于最大页码减一
			}
			pageCount.setCurrentPage(currentPage);
		}
		currentPage = pageCount.getCurrentPage();
		employeesList = service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}

	public String search() {
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
		employeesList = service.getEmployeeByName(searchName);
		return "search";
	}

	public String initialize() throws Exception {
		pageCount.setCurrentPage(0);

		return "initialize";
	}

	public void ExportToExcel() throws Exception {
		employeesList = service.getAllEmployees();
		excel.EmployeesExcel(employeesList);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		try {
			response.getWriter().append("{\"isSuccess\":" + true + "}"); // 返回给ajax的值，json格式
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
