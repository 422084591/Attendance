package model;

public class CheckReport {
	private int id;					//id
	private String staffCode;	//员工编码
	private String name;	//员工名字
	private String morningBusinessHours;//早上上班打卡时间
	private String afternoonBusinessHours;//下午下班打卡时间
	private String attendanceSituation;				//出勤情况
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAttendanceSituation() {
		return attendanceSituation;
	}
	public void setAttendanceSituation(String attendanceSituation) {
		this.attendanceSituation = attendanceSituation;
	}

}
