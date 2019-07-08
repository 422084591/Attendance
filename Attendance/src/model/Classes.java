package model;

public class Classes {
	private int id;				//id
	private String code;		//班次编号
	private String name;		//班次名字，早班晚班
	private String morningBusinessHours;	//早上上班时间
	private String afternoonBusinessHours;	//晚上上班时间
	private String remark;					//备注
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
	
}
