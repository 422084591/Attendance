package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import model.PageCount;
import model.PunchCard;
import model.RepairCard;
import service.RepairCardServiceImpl;
import util.ExcelExportUtil;
import util.ExcelExportUtil;

public class RepairCardAction extends ActionSupport{
	RepairCardServiceImpl service=new RepairCardServiceImpl();
	private int  id;					//id
	private String repairCradMan;		//打卡人
	private String  repairCradDate;		//打卡日期
	private String repairCradReason;	//打卡原因
	//==================================================
	private int maxPage;//最大页码
	private int minPage;//最小页码
	private int currentPage=-1;//当前页码
	private PageCount pageCount=PageCount.getInstance();//页码对象
	private int[] ids;//id数组，用于批量删除
	private RepairCard repairCard=new RepairCard();//补卡单对象
	private List<RepairCard> repairCardList=new ArrayList<RepairCard>();//补卡单链表，用于储存查询数据
	private String searchName;//补卡单查询名字
	ExcelExportUtil excel=new ExcelExportUtil();//excel工具类
	
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
	public String getRepairCradMan() {
		return repairCradMan;
	}
	public void setRepairCradMan(String repairCradMan) {
		this.repairCradMan = repairCradMan;
	}
	public String getRepairCradDate() {
		return repairCradDate;
	}
	public void setRepairCradDate(String repairCradDate) {
		this.repairCradDate = repairCradDate;
	}
	public String getRepairCradReason() {
		return repairCradReason;
	}
	public void setRepairCradReason(String repairCradReason) {
		this.repairCradReason = repairCradReason;
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
	public RepairCard getRepairCard() {
		return repairCard;
	}
	public void setRepairCard(RepairCard repairCard) {
		this.repairCard = repairCard;
	}
	public List<RepairCard> getRepairCardList() {
		return repairCardList;
	}
	public void setRepairCardList(List<RepairCard> repairCardList) {
		this.repairCardList = repairCardList;
	}
	//===============================================================
	public String add() {//添加补卡单信息
		repairCard.setId(id);
		repairCard.setRepairCradDate(repairCradDate);
		repairCard.setRepairCradMan(repairCradMan);
		repairCard.setRepairCradReason(repairCradReason);
		service.addRepairCard(repairCard);
		pageCount.setMaxPage(service.getMaxPage());		//获取当前记录的页码
		pageCount.setCurrentPage(pageCount.getMaxPage());//添加记录后自动跳转到最后一页
		return "add";
	}
	public String delete() {//删除打卡单信息
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.deleteRepairCardById(id);
		return "delete";
		}
	public String remove() {//批量删除打卡单信息
		currentPage = pageCount.getCurrentPage();			//删除完回到之前的页码
		service.removeRepairCardByIds(ids);
		return "remove";
	}
	public String update() {//修改打卡单信息
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		repairCard.setId(id);
		repairCard.setRepairCradDate(repairCradDate);
		repairCard.setRepairCradMan(repairCradMan);
		repairCard.setRepairCradReason(repairCradReason);
		service.updateRepairCardById(id, repairCard);
		return "update";
	}
	public String edit() {//编辑打卡单信息
		currentPage = pageCount.getCurrentPage();			//编辑完保持之前的页码
		repairCard=service.getRepairCardById(id);
		return "edit";
	}
	public String limit() {//通过页码查找打卡单信息
		pageCount.setMaxPage(service.getMaxPage()); // 获取记录的页数，每次检测，防治删除数据后页码减少或者添加数据后页码增加
		if(currentPage!=-1) {
			if (currentPage > pageCount.getMaxPage()) {
				currentPage = pageCount.getMaxPage(); // 如果当前页码大于等于最大页码的话，让当前页码等于最大页码减一
			}
			pageCount.setCurrentPage(currentPage);
		}	
		currentPage = pageCount.getCurrentPage();
		repairCardList=service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}
	public String search() {//查找打卡单信息
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
		repairCardList=service.getRepairCardByrepairCradMan(searchName);
		return "search";
	}
	public String initialize() throws Exception {
		pageCount.setCurrentPage(0);
		return "initialize";
	}
	
	public void ExportToExcel() throws Exception {//导出到excel
		repairCardList=service.getAll();
		excel.RepairCardExcel(repairCardList);
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
