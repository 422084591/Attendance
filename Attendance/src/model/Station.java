package model;

public class Station {
	private int stationId;//岗位Id
	private String stationCode;//岗位编码
	private String stationName;//岗位名称
	private String department;//所在部门
	private String immediateSuperior;//直接上级
	private String immediateSuperiorCode;//直接上级编码
	private String stationCategory;//岗位类别
	private String stationDescription;//岗位职责描述

	
	public String getImmediateSuperiorCode() {
		return immediateSuperiorCode;
	}
	public void setImmediateSuperiorCode(String immediateSuperiorCode) {
		this.immediateSuperiorCode = immediateSuperiorCode;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getImmediateSuperior() {
		return immediateSuperior;
	}
	public void setImmediateSuperior(String immediateSuperior) {
		this.immediateSuperior = immediateSuperior;
	}
	public String getStationCategory() {
		return stationCategory;
	}
	public void setStationCategory(String stationCategory) {
		this.stationCategory = stationCategory;
	}
	public String getStationDescription() {
		return stationDescription;
	}
	public void setStationDescription(String stationDescription) {
		this.stationDescription = stationDescription;
	}
	
}
