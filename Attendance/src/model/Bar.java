package model;

public class Bar {

	public String date;

	public int normal_num;

	public int late_num;

	public int leaveEarly_num;

	public int absenteeism_num;
	/** 时间 **/
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/** 正常打卡人数 **/
	public int getNormal_num() {
		return normal_num;
	}

	public void setNormal_num(int normal_num) {
		this.normal_num = normal_num;
	}

	/**迟到人数 **/
	public int getLate_num() {
		return late_num;
	}

	public void setLate_num(int late_num) {
		this.late_num = late_num;
	}

	/** 早退打卡人数 **/
	public int getLeaveEarly_num() {
		return leaveEarly_num;
	}

	public void setLeaveEarly_num(int leaveEarly_num) {
		this.leaveEarly_num = leaveEarly_num;
	}

	/** 旷工打卡人数 **/
	public int getAbsenteeism_num() {
		return absenteeism_num;
	}

	public void setAbsenteeism_num(int absenteeism_num) {
		this.absenteeism_num = absenteeism_num;
	}

}
