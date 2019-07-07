package model;

public class Department {
	private int departmentID;//部门id
	private String departmentCode;//部门编码
	private String departmentName;//部门名称
	private String departmentHead;//部门负责人
	private String departmentResponsibility;//部门职责
	private int superiorDepartmentId;//上级部门id
	private String superiorDepartmentName;//上级部门Id，关联自己
	public Department() {
		super();
	}
	public Department(int departmentID, String departmentCode, String departmentName, String departmentHead,
			String departmentResponsibility, int superiorDepartmentId) {
		super();
		this.departmentID = departmentID;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.departmentHead = departmentHead;
		this.departmentResponsibility = departmentResponsibility;
		this.superiorDepartmentId = superiorDepartmentId;
	}
	
	public String getSuperiorDepartmentName() {
		return superiorDepartmentName;
	}
	public void setSuperiorDepartmentName(String superiorDepartmentName) {
		this.superiorDepartmentName = superiorDepartmentName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}
	public String getDepartmentResponsibility() {
		return departmentResponsibility;
	}
	public void setDepartmentResponsibility(String departmentResponsibility) {
		this.departmentResponsibility = departmentResponsibility;
	}
	public int getSuperiorDepartmentId() {
		return superiorDepartmentId;
	}
	public void setSuperiorDepartmentId(int superiorDepartmentId) {
		this.superiorDepartmentId = superiorDepartmentId;
	}

	
}
