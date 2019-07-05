package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Department;
import model.Employees;
import model.PageCount;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeesServiceImpl;
import util.ExcelExportUtil;

public class DepartmentAction extends ActionSupport {
	DepartmentService<Department> service=new DepartmentServiceImpl();
	EmployeesServiceImpl service_E=new EmployeesServiceImpl();
	private int departmentID;//部门id
	private String departmentCode;//部门编码
	private String departmentName;//部门名称
	private String departmentHead;//部门负责人(用来查找员工，对应员工的name)
	private String departmentResponsibility;//部门职责
	private int superiorDepartmentId;//上级部门id
	//新增属性
	private String superiorDepartmentName;
	private List<Department> departmentList=new ArrayList<Department>();
	private Department department=new Department();
	private int[] departmentIds;
	private String searchName;
private int maxPage;
private int minPage;
private int currentPage=-1;
private PageCount pageCount=PageCount.getInstance();
//==============================================================
private String staffCode; // 员工编码
private String name; // 姓名
private List<Employees> employeesList = new ArrayList<Employees>();
private Employees employee = new Employees();
ExcelExportUtil excel =new ExcelExportUtil();


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
public List<Employees> getEmployeesList() {
	return employeesList;
}
public void setEmployeesList(List<Employees> employeesList) {
	this.employeesList = employeesList;
}
public Employees getEmployee() {
	return employee;
}
public void setEmployee(Employees employee) {
	this.employee = employee;
}
public String getSuperiorDepartmentName() {
	return superiorDepartmentName;
}
public void setSuperiorDepartmentName(String superiorDepartmentName) {
	this.superiorDepartmentName = superiorDepartmentName;
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

	public int[] getDepartmentIds() {
		return departmentIds;
	}


	public void setDepartmentIds(int[] departmentIds) {
		this.departmentIds = departmentIds;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public int getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}


	public String getDepartmentCode() {
		return departmentCode;
	}


	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentHead() {
		return departmentHead;
	}


	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}


	public String getDepartmentResponsibility() {
		return departmentResponsibility;
	}


	public void setDepartmentResponsibility(String departmentResponsibility) {
		this.departmentResponsibility = departmentResponsibility;
	}


	public int getSuperiorDepartmentId() {
		return superiorDepartmentId;
	}


	public void setSuperiorDepartmentId(int superiorDepartmentId) {
		this.superiorDepartmentId = superiorDepartmentId;
	}


	public List<Department> getDepartmentList() {
		return departmentList;
	}


	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}


	//=========================================================================================
	public String add() {
		department.setDepartmentID(departmentID);
		department.setDepartmentCode(departmentCode);
		department.setDepartmentHead(departmentHead);
		department.setDepartmentName(departmentName);
		department.setDepartmentResponsibility(departmentResponsibility);
		department.setSuperiorDepartmentId(superiorDepartmentId);
		service.addDepartment(department);
		pageCount.setMaxPage(service.getMaxPage());		//获取当前记录的页码
		pageCount.setCurrentPage(pageCount.getMaxPage());//添加记录后自动跳转到最后一页
		return "add";
	}
	public String delete() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.deletaDepartmentByDempartmentId(departmentID);
		return "delete";
	}
	public String remove() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.removeDepartmentByDepartmentIds(departmentIds);
		return "remove";
	}
	public String update() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		department.setDepartmentID(departmentID);
		department.setDepartmentCode(departmentCode);
		department.setDepartmentHead(departmentHead);
		department.setDepartmentName(departmentName);
		department.setDepartmentResponsibility(departmentResponsibility);
		department.setSuperiorDepartmentId(superiorDepartmentId);
		service.updateDepartmentByDepartmentId(departmentID, department);
		return "update";
	}
	public String edit() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		employeesList=service_E.getAllEmployees();
		department=service.getDepartmentByDepartmentID(departmentID);
		service_E.getAllEmployees();
		return "edit";
	}
	public String search() {
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
			departmentList=service.getDepartmentByDepartmentName(searchName);
		return "search";
	}
	public String limit() {
		pageCount.setMaxPage(service.getMaxPage()); // 获取记录的页数，每次检测，防治删除数据后页码减少或者添加数据后页码增加
		if(currentPage!=-1) {
			if (currentPage > pageCount.getMaxPage()) {
				currentPage = pageCount.getMaxPage(); // 如果当前页码大于等于最大页码的话，让当前页码等于最大页码减一
			}
			pageCount.setCurrentPage(currentPage);
		}	
		currentPage = pageCount.getCurrentPage();
		employeesList=service_E.getAllEmployees();
		departmentList=service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}	
	public String initialize() throws Exception {
		pageCount.setCurrentPage(0);
		return "initialize";
	}
	public void ExportToExcel() throws Exception {
		departmentList=service.getAllDepartmentInfo();
		excel.DepartmentExcel(departmentList);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		try {
			response.getWriter().append("{\"isSuccess\":"+true+"}");	//返回给ajax的值，json格式
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
