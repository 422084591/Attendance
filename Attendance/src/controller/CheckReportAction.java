package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;

import model.Bar;
import model.Classes;
import model.PageCount;
import model.PunchCard;
import service.CheckReportServiceImpl;
import service.ClassesServiceImpl;
import util.ExcelExportUtil;

public class CheckReportAction extends ActionSupport {
	CheckReportServiceImpl service = new CheckReportServiceImpl();
	ClassesServiceImpl service_C = new ClassesServiceImpl();
	private int id; // id
	private String staffCode;// 员工编码
	private String punchCardMan; // 打卡人
	private String punchCardDate; // 打卡时间
	private String punchCardDate_end;// 结束打卡时间
	private String remark; // 备注
	// ===========================================
	private int maxPage; // 最大页码
	private int minPage; // 最小页码
	private int currentPage = -1;// 当前页码
	private PageCount pageCount = PageCount.getInstance(); // 储存页码的对象，单例
	private PunchCard punchCard = new PunchCard(); // 打卡单对象
	private int[] ids; // id数组，用于批量删除
	private List<PunchCard> punchCardList = new ArrayList<PunchCard>(); // 打卡链表，用于查找
	private String searchName; // 查找的打卡人名字，用于查找
	private String searchFirstTime;// 查找的开始时间
	private String searchLastTime;// 查找的结束时间
	Classes classes = new Classes();// 班次对象
	List<Classes> classesList = new ArrayList<Classes>();// 班次链表，用于查找，以及根据班次信息计算薪水
	ExcelExportUtil excel = new ExcelExportUtil(); // 工具类用于导出excel文档
	private String attendanceSituation;// 考勤情况

	public String getAttendanceSituation() {
		return attendanceSituation;
	}

	public void setAttendanceSituation(String attendanceSituation) {
		this.attendanceSituation = attendanceSituation;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public String getSearchFirstTime() {
		return searchFirstTime;
	}

	public void setSearchFirstTime(String searchFirstTime) {
		this.searchFirstTime = searchFirstTime;
	}

	public String getSearchLastTime() {
		return searchLastTime;
	}

	public void setSearchLastTime(String searchLastTime) {
		this.searchLastTime = searchLastTime;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getPunchCardDate_end() {
		return punchCardDate_end;
	}

	public void setPunchCardDate_end(String punchCardDate_end) {
		this.punchCardDate_end = punchCardDate_end;
	}

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

	public String getPunchCardMan() {
		return punchCardMan;
	}

	public void setPunchCardMan(String punchCardMan) {
		this.punchCardMan = punchCardMan;
	}

	public String getPunchCardDate() {
		return punchCardDate;
	}

	public void setPunchCardDate(String punchCardDate) {
		this.punchCardDate = punchCardDate;
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

	public PunchCard getPunchCard() {
		return punchCard;
	}

	public void setPunchCard(PunchCard punchCard) {
		this.punchCard = punchCard;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public List<PunchCard> getPunchCardList() {
		return punchCardList;
	}

	public void setPunchCardList(List<PunchCard> punchCardList) {
		this.punchCardList = punchCardList;
	}

	// =======================================================================================
	public String limit() { // 通过页码查询记录
		pageCount.setMaxPage(service.getMaxPage()); // 获取记录的页数，每次检测，防治删除数据后页码减少或者添加数据后页码增加

		if (currentPage != -1) {
			if (currentPage > pageCount.getMaxPage()) {
				currentPage = pageCount.getMaxPage(); // 如果当前页码大于等于最大页码的话，让当前页码等于最大页码减一
			}
			pageCount.setCurrentPage(currentPage);
		}
		currentPage = pageCount.getCurrentPage();
		punchCardList = service.getAllByLimit(pageCount.getCurrentPage());
		return "limit";
	}

	public String search() throws ParseException {// 查询功能，可对考勤人名字，考勤时间进行查询
		pageCount.setCurrentPage(0);
		pageCount.setMaxPage(0);
		punchCardList = service.getCheckReportByName(searchName);
		Date searchFirstTimeDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchFirstTime);
		if (searchLastTime.equals("")) { // 当结束日输入为空的时候，让它默认为开始月份的最后一天
			Date s = new SimpleDateFormat("yyyy-MM-dd").parse(searchFirstTime);
			Calendar searchFirstTimCalendar = Calendar.getInstance();
			searchFirstTimCalendar.setTime(searchFirstTimeDate);
			int maxDay = searchFirstTimCalendar.getActualMaximum(searchFirstTimCalendar.DATE);
			searchFirstTimCalendar.set(Calendar.DAY_OF_MONTH, maxDay);
			s = searchFirstTimCalendar.getTime();
			searchLastTime = new SimpleDateFormat("yyyy-MM-dd").format(s);
		}
		Date searchLastTimeDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchLastTime);
		for (int i = 0; i < punchCardList.size(); i++) {
			if (punchCardList.get(i).getPunchCardDate().equals("")
					&& punchCardList.get(i).getPunchCardDate().equals("")) {
				punchCardList.remove(i);
				i--;//删除完记录，链表后面的记录会向前移一位，需要把链表“指针”减一，让“指针”停留在当前记录，下一次不会增加
			}
			if (!punchCardList.get(i).getPunchCardDate().equals("")) { // 判断上班打卡日期是否为空
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(punchCardList.get(i).getPunchCardDate());
				if (date2.getTime() < searchFirstTimeDate.getTime() || date2.getTime() > searchLastTimeDate.getTime()) {
					punchCardList.remove(i);
					i--;
				}
			} else if (!punchCardList.get(i).getPunchCardDate_end().equals("")) {// 判断下班打卡日期是否为空
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(punchCardList.get(i).getPunchCardDate_end());
				if (date2.getTime() < searchFirstTimeDate.getTime() || date2.getTime() > searchLastTimeDate.getTime()) {
					punchCardList.remove(i);
					i--;
				}
			}
		}
		return "search";

	}

	public String initialize() throws Exception {// 点击左边列表时调用的方法，让当前页码归零，以及对考勤信息的分析（是否迟到早退）
		pageCount.setCurrentPage(0);
		punchCardList = service.getAll();
		try {
			for (int i = 0; i < punchCardList.size(); i++) {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(punchCardList.get(i).getPunchCardDate());
				for (int e = i + 1; e < punchCardList.size(); e++) {
					Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm")
							.parse(punchCardList.get(e).getPunchCardDate());
					if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth()
							&& date1.getDate() == date2.getDate()
							&& punchCardList.get(i).getPunchCardMan().equals(punchCardList.get(e).getPunchCardMan())) {
						String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date2);
						punchCardList.remove(e);
						e--;
						punchCardList.get(i).setPunchCardDate_end(endTime);
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		classesList = service_C.getAll();
		Classes c = classesList.get(0);
		for (PunchCard p : punchCardList) { // 根据打卡时间判断是否是正常，迟到，早退或者是旷工
			try {
				p.setRemark("正常");
				if (p.getPunchCardDate() == null || p.getPunchCardDate_end() == null) {
					p.setRemark("旷工");
				} else {
					Date date3 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(p.getPunchCardDate());
					Date date4 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(p.getPunchCardDate_end());
					Date morningBusinessHours = new SimpleDateFormat("HH:mm").parse(c.getMorningBusinessHours());
					Date afternoonBusinessHours = new SimpleDateFormat("HH:mm").parse(c.getAfternoonBusinessHours());
					if (date3.getHours() > morningBusinessHours.getHours()) {
						p.setRemark("迟到");
					} else if (date4.getHours() < afternoonBusinessHours.getHours()) {
						p.setRemark("早退");
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.remove();
		for (PunchCard p : punchCardList) {
			service.add(p);
		}
		pageCount.setMaxPage(service.getMaxPage());
		return "initialize";

	}

	public void ExportToExcel() throws Exception { // 用于导出Excel表到F盘
		CheckReportAction action = new CheckReportAction();
		punchCardList = service.getAllFromCheckReport();
		excel.CheckReportExcel(punchCardList);
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

	public void getData() throws Exception {//获得所有考勤记录信息，并且对考勤记录进行分析，用于index.jsp页面的图形化显示
		List<Bar> barList = new ArrayList<Bar>();
		CheckReportAction action = new CheckReportAction();
		action.initialize();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		punchCardList = service.getAllFromCheckReport();
		// 对数据进行处理分类
		for (int i = 0; i < punchCardList.size(); i++) {
			boolean temp = false;
			if (!punchCardList.get(i).getPunchCardDate().equals("")) {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(punchCardList.get(i).getPunchCardDate());// 格式转换
				String str1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
				if (barList.size() < 7) { // 显示最近七天的考勤情况
					for (Bar b : barList) { // 如果链表里面不包含当前考勤记录的时间，添加一条
						if (b.getDate().equals(str1)) {
							temp = true;
						}
					}
					if (temp == false) {
						Bar bar = new Bar();
						bar.setDate(str1);
						barList.add(bar);
					}
				}
			}
		}

		for (int i = 0; i < punchCardList.size(); i++) {
			String str1 = null;
			if (!punchCardList.get(i).getPunchCardDate().equals("")) {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(punchCardList.get(i).getPunchCardDate());// 格式转换
				str1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
			} else if (!punchCardList.get(i).getPunchCardDate_end().equals("")) {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(punchCardList.get(i).getPunchCardDate_end());// 格式转换
				str1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
			}
			for (Bar b : barList) {//计算每个日期中正常，迟到，早退，旷工的人数
				if (b.getDate().equals(str1)) {
					if (punchCardList.get(i).getAttendanceSituation().equals("正常")) {
						b.setNormal_num(b.getNormal_num() + 1);
					}
					if (punchCardList.get(i).getAttendanceSituation().equals("迟到")) {
						b.setLate_num(b.getLate_num() + 1);
					}
					if (punchCardList.get(i).getAttendanceSituation().equals("早退")) {
						b.setLeaveEarly_num(b.getLeaveEarly_num() + 1);
					}
					if (punchCardList.get(i).getAttendanceSituation().equals("旷工")) {
						b.setAbsenteeism_num(b.getAbsenteeism_num() + 1);
					}
				}
			}
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(barList));
		// 写数据到前台
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
