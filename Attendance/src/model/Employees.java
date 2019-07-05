package model;

public class Employees {
	private int emp_id;
	private String staffCode;	//员工编码
	private String name; // 姓名
	private String sex; // 性别
	private int age;// 年龄
	private String nation;// 民族
	private String idNumber;// 身份证
	private String salary;// 薪水
	private String phone;// 联系电话
	private String emergencyContact;// 紧急联系人
	private String emergencyContactNumber;// 紧急联系人电话
	private int stationId;// 岗位ID
	private String individualDescription;// 个人描述
	private String stationName;//岗位名称，通过岗位Id查询来的
	public Employees(int emp_id, String staffCode, String name, String sex, int age, String nation, String idNumber,
			String salary, String phone, String emergencyContact, String emergencyContactNumber, int stationId,
			String individualDescription) {
		super();
		this.emp_id = emp_id;
		this.staffCode = staffCode;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.nation = nation;
		this.idNumber = idNumber;
		this.salary = salary;
		this.phone = phone;
		this.emergencyContact = emergencyContact;
		this.emergencyContactNumber = emergencyContactNumber;
		this.stationId = stationId;
		this.individualDescription = individualDescription;
	}
	public Employees() {
		super();
	}
	
	
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getIndividualDescription() {
		return individualDescription;
	}
	public void setIndividualDescription(String individualDescription) {
		this.individualDescription = individualDescription;
	}
	

	

}
