package model;

public class CheckReportPageCount {
	private CheckReportPageCount() {};
	private static final CheckReportPageCount checkReportPageCount=new CheckReportPageCount();	//单例模式
	public static CheckReportPageCount getInstance() {
		return checkReportPageCount;
	}
}
