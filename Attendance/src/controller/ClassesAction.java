package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import model.Classes;
import model.PageCount;
import service.ClassesServiceImpl;
import util.ExcelExportUtil;

public class ClassesAction extends ActionSupport{
	ClassesServiceImpl service=new ClassesServiceImpl();
	private int id;				//id
	private String code;		//班次编号
	private String name;		//班次名字，早班晚班
	private String morningBusinessHours;	//早上上班时间
	private String afternoonBusinessHours;	//晚上上班时间
	private String remark;					//备注
//===================================================================
	private int maxPage;
	private int minPage;
	private int currentPage=-1;
	private PageCount pageCount=PageCount.getInstance();
	private int[] ids;
	private List<Classes> classesList=new ArrayList<Classes>();
	private Classes classes=new Classes();
	private String searchName;
	ExcelExportUtil excel =new ExcelExportUtil();
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMorningBusinessHours() {
		return morningBusinessHours;
	}
	public void setMorningBusinessHours(String morningBusinessHours) {
		this.morningBusinessHours = morningBusinessHours;
	}
	public String getAfternoonBusinessHours() {
		return afternoonBusinessHours;
	}
	public void setAfternoonBusinessHours(String afternoonBusinessHours) {
		this.afternoonBusinessHours = afternoonBusinessHours;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public PageCount getPageCount() {
		return pageCount;
	}
	public void setPageCount(PageCount pageCount) {
		this.pageCount = pageCount;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public List<Classes> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	
	public String add() {
		classes.setId(id);
		classes.setCode(code);
		classes.setName(name);
		classes.setRemark(remark);
		classes.setAfternoonBusinessHours(afternoonBusinessHours);
		classes.setMorningBusinessHours(morningBusinessHours);
		service.addClasses(classes);
		pageCount.setMaxPage(service.getMaxPage());		//获取当前记录的页码
		pageCount.setCurrentPage(pageCount.getMaxPage());//添加记录后自动跳转到最后一页
		return "add";
	}

	public String delete() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.deleteClassesById(id);
		return "delete";
	}

	public String remove() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.removeClassesByIds(ids);
		return "remove";
	}

	public String edit() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		classes=service.getClassesById(id);
		return "edit";
	}

	public String update() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		classes.setId(id);
		classes.setCode(code);
		classes.setName(name);
		classes.setRemark(remark);
		classes.setAfternoonBusinessHours(afternoonBusinessHours);
		classes.setMorningBusinessHours(morningBusinessHours);
		service.updateClassesById(id, classes);
		return "update";
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
		classesList = service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}

	public String search() {
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
		classesList = service.getClassesByName(searchName);
		return "search";
	}
	public String initialize() throws Exception {
		pageCount.setCurrentPage(0);
		
		return "initialize";
	}
	
	public void ExportToExcel() throws Exception {
		classesList=service.getAll();
		excel.ClassesExcel(classesList);
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
