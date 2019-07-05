package model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.util.converter.DateStringConverter;

public class PunchCard {
	private int id;					//id
	private String staffCode;//员工编码
	private String punchCardMan;	//打卡人
	private String punchCardDate;	//打卡时间
	private String punchCardDate_end;//结束打卡时间
	private String remark;				//备注
	private String attendanceSituation;//考勤情况
	
	public String getAttendanceSituation() {
		return attendanceSituation;
	}
	public void setAttendanceSituation(String attendanceSituation) {
		this.attendanceSituation = attendanceSituation;
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

	
}
