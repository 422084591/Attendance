package model;

/**
 * @author Administrator
 *
 */
public class RepairCard {
	private int  id;					//id
	private String repairCradMan;		//打卡人
	private String  repairCradDate;		//打卡日期
	private String repairCradReason;	//打卡原因
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRepairCradMan() {
		return repairCradMan;
	}
	public void setRepairCradMan(String repairCradMan) {
		this.repairCradMan = repairCradMan;
	}
	public String getRepairCradDate() {
		return repairCradDate;
	}
	public void setRepairCradDate(String repairCradDate) {
		this.repairCradDate = repairCradDate;
	}
	public String getRepairCradReason() {
		return repairCradReason;
	}
	public void setRepairCradReason(String repairCradReason) {
		this.repairCradReason = repairCradReason;
	}
	
	
}
