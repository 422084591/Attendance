package model;

public class PaySalary {
	private int id;				//id
	private String staffCode;	//员工编码
	private String salariedMan;	//领薪人名字
	private String salary;		//薪水
	private String calculateStartDate;//计算开始时间
	private String calculateEndDate;	//计算结束时间
	private String staffSalary;//员工薪水
	private String classes;//员工班次
	private String paidTime;//领薪时间
	public int getId() {
		return id;
	}
	

	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	public String getPaidTime() {
		return paidTime;
	}


	public void setPaidTime(String paidTime) {
		this.paidTime = paidTime;
	}


	public String getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(String staffSalary) {
		this.staffSalary = staffSalary;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getSalariedMan() {
		return salariedMan;
	}
	public void setSalariedMan(String salariedMan) {
		this.salariedMan = salariedMan;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCalculateStartDate() {
		return calculateStartDate;
	}
	public void setCalculateStartDate(String calculateStartDate) {
		this.calculateStartDate = calculateStartDate;
	}
	public String getCalculateEndDate() {
		return calculateEndDate;
	}
	public void setCalculateEndDate(String calculateEndDate) {
		this.calculateEndDate = calculateEndDate;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	
	
}
