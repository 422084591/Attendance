package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Leave;
import model.PageCount;
import service.LeaveServiceImpl;
import util.ExcelExportUtil;

public class LeaveAction extends ActionSupport{
	LeaveServiceImpl service=new LeaveServiceImpl();
	private int id;				//请假记录id
	private String pleaseDummyMan;//请假人
	private String startTime;//请假开始时间
	private String endTime;//请假结束时间
	private String leaveReason;//请假原因
	//==============================================================
	private int maxPage;
	private int minPage;
	private int currentPage=-1;
	private String searchName;
	private PageCount pageCount=PageCount.getInstance();
	private int[] ids;
	private List<Leave> leaveList=new ArrayList<Leave>();
	private Leave leave=new Leave();
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
	public String getPleaseDummyMan() {
		return pleaseDummyMan;
	}
	public void setPleaseDummyMan(String pleaseDummyMan) {
		this.pleaseDummyMan = pleaseDummyMan;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
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
	public List<Leave> getLeaveList() {
		return leaveList;
	}
	public void setLeaveList(List<Leave> leaveList) {
		this.leaveList = leaveList;
	}
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	//=================================================================
	public String add() {
		leave.setEndTime(endTime);
		leave.setId(id);
		leave.setLeaveReason(leaveReason);
		leave.setPleaseDummyMan(pleaseDummyMan);
		leave.setStartTime(startTime);
		service.addLeave(leave);
		pageCount.setMaxPage(service.getMaxPage());		//获取当前记录的页码
		pageCount.setCurrentPage(pageCount.getMaxPage());//添加记录后自动跳转到最后一页
		return "add";
	}
	public String delete() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.deleteLeaveById(id);
		return "delete";
	}
	public String remove() {
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.removeLeaveByIds(ids);
		return "remove";
	}
	public String update() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		leave.setEndTime(endTime);
		leave.setId(id);
		leave.setLeaveReason(leaveReason);
		leave.setPleaseDummyMan(pleaseDummyMan);
		leave.setStartTime(startTime);
		service.updateLeaveById(id, leave);
		return "update";
	}
	
	
	public String edit() {
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		leave=service.getLeaveById(id);
				return "edit";
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
		leaveList=service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}
	public String search() {
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
		leaveList=service.getLeaveByPleaseDummyMan(searchName);
		return "search";
	}
	public String initialize() throws Exception {
		pageCount.setCurrentPage(0);
	
		return "initialize";
	}
	public void ExportToExcel() throws Exception {
		leaveList=service.getAll();
		excel.LeaveExcel(leaveList);
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
