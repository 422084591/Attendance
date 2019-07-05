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
import model.PageCount;
import model.Station;
import service.DepartmentServiceImpl;
import service.StationServiceImpl;
import util.ExcelExportUtil;

public class StationAction extends ActionSupport {
	StationServiceImpl service=new StationServiceImpl();
	DepartmentServiceImpl service_D=new DepartmentServiceImpl();
	private int stationId;//岗位Id
	private String stationCode;//岗位编码
	private String stationName;//岗位名称
	private String department;//所在部门(用来查找部门，对应部门的departmentName)
	private String immediateSuperior;//直接上级
	private String stationCategory;//岗位类别
	private String stationDescription;//岗位职责描述
	private String immediateSuperiorCode;//上级部门编码
	//
	private List<Station> stationList=new ArrayList<Station>();
	private Station station=new Station();
	private int[] stationIds;
private String searchName;
private int maxPage;
private int minPage;
private int currentPage=-1;
private PageCount pageCount=PageCount.getInstance();
//==========================================================
private List<Department> departmentList=new ArrayList<Department>();
private Department department_D=new Department();
private String departmentCode;
private String departmentName;
 ExcelExportUtil excel=new ExcelExportUtil();


	public List<Department> getDepartmentList() {
	return departmentList;
}
public void setDepartmentList(List<Department> departmentList) {
	this.departmentList = departmentList;
}

	public Department getDepartment_D() {
	return department_D;
}
public void setDepartment_D(Department department_D) {
	this.department_D = department_D;
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
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public int[] getStationIds() {
		return stationIds;
	}
	public void setStationIds(int[] stationIds) {
		this.stationIds = stationIds;
	}
	public List<Station> getStationList() {
		return stationList;
	}
	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getImmediateSuperior() {
		return immediateSuperior;
	}
	public void setImmediateSuperior(String immediateSuperior) {
		this.immediateSuperior = immediateSuperior;
	}
	public String getStationCategory() {
		return stationCategory;
	}
	public void setStationCategory(String stationCategory) {
		this.stationCategory = stationCategory;
	}
	public String getStationDescription() {
		return stationDescription;
	}
	public void setStationDescription(String stationDescription) {
		this.stationDescription = stationDescription;
	}
	//==============================================================================
	public String add() {
		station.setStationId(stationId);
		station.setDepartment(department);
		station.setImmediateSuperior(immediateSuperior);
		station.setStationCategory(stationCategory);
		station.setStationCode(stationCode);
		station.setStationName(stationName);
		station.setStationDescription(stationDescription);
		service.addStaticon(station);
		pageCount.setMaxPage(service.getMaxPage());		//获取当前记录的页码
		pageCount.setCurrentPage(pageCount.getMaxPage());//添加记录后自动跳转到最后一页
		return "add";
	}
	public String remove() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.removeStationByStationIds(stationIds);
		return "remove";
	}
	public String delete() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.deleteStationByStationId(stationId);
		return "delete";
	}
	public String update() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		station.setStationId(stationId);
		station.setDepartment(department);
		station.setImmediateSuperior(immediateSuperior);
		station.setStationCategory(stationCategory);
		station.setStationCode(stationCode);
		station.setStationName(stationName);
		station.setStationDescription(stationDescription);
		service.updateStationByStationId(stationId,station);
		return "update";
	}
	public String edit() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		stationList=service.getAllStations();
		station=service.getStationByStationId(stationId);
		departmentList=service_D.getAllDepartmentInfo();
		return "edit";
	}
	public String search() {
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
		stationList=service.getStationByStationName(searchName);
		return "search";
	}
	public String limit() {
		pageCount.setMaxPage(service.getMaxPage()); // 获取记录的页数，每次检测，防治删除数据后页码减少或者添加数据后页码增加
		System.out.println("在获取页码中。。。。。。");
		if(currentPage!=-1) {
			if (currentPage > pageCount.getMaxPage()) {
				currentPage = pageCount.getMaxPage(); // 如果当前页码大于等于最大页码的话，让当前页码等于最大页码减一
			}
			pageCount.setCurrentPage(currentPage);
		}	
		currentPage = pageCount.getCurrentPage();
		stationList=service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}
	public String initialize() {
		pageCount.setCurrentPage(0);
		return "initialize";
	}
	public void ExportToExcel() throws Exception {
		stationList=service.getAllStations();
		excel.StationExcel(stationList);
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
