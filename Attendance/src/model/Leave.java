package model;

public class Leave {	
private int id;				//请假记录id
private String pleaseDummyMan;//请假人
private String startTime;//请假开始时间
private String endTime;//请假结束时间
private String leaveReason;//请假原因
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

}
