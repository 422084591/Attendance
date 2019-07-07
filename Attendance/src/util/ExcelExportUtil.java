package util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.*;
public class ExcelExportUtil {
	
	public void EmployeesExcel(List<Employees> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://EmployeesExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("user", 0);
			//创建表头
			String []tableHead={"Emp_Id","员工编码","姓名","性别","年龄","名族","身份证","薪水","联系电话","紧急联系人","紧急联系人电话","岗位ID","个人描述"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getEmp_id())));
				sheet.addCell(new Label(1,i+1,list.get(i).getStaffCode()));
				sheet.addCell(new Label(2,i+1,list.get(i).getName()));
				sheet.addCell(new Label(3,i+1,list.get(i).getSex()));
				sheet.addCell(new Label(4,i+1,String.valueOf(list.get(i).getAge())));
				sheet.addCell(new Label(5,i+1,list.get(i).getNation()));
				sheet.addCell(new Label(6,i+1,list.get(i).getIdNumber()));
				sheet.addCell(new Label(7,i+1,list.get(i).getSalary()));
				sheet.addCell(new Label(8,i+1,list.get(i).getPhone()));
				sheet.addCell(new Label(9,i+1,list.get(i).getEmergencyContact()));
				sheet.addCell(new Label(10,i+1,list.get(i).getEmergencyContactNumber()));
				sheet.addCell(new Label(11,i+1,String.valueOf(list.get(i).getStationId())));
				sheet.addCell(new Label(12,i+1,list.get(i).getIndividualDescription()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	public void DepartmentExcel(List<Department> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://DepartmentExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("Department", 0);
			//创建表头
			String []tableHead={"部门ID","部门编码","部门名称","部门负责人","部门职责","上级部门ID"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getDepartmentID())));
				sheet.addCell(new Label(1,i+1,list.get(i).getDepartmentCode()));
				sheet.addCell(new Label(2,i+1,list.get(i).getDepartmentName()));
				sheet.addCell(new Label(3,i+1,list.get(i).getDepartmentHead()));
				sheet.addCell(new Label(4,i+1,list.get(i).getDepartmentResponsibility()));
				sheet.addCell(new Label(5,i+1,String.valueOf(list.get(i).getSuperiorDepartmentId())));

			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	public void StationExcel(List<Station> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://StationExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("Station", 0);
			//创建表头
			String []tableHead={"岗位ID","岗位编码","岗位名称","所在部门","直接上级","岗位类别","岗位职责描述"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getStationId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getStationCode()));
				sheet.addCell(new Label(2,i+1,list.get(i).getStationName()));
				sheet.addCell(new Label(3,i+1,list.get(i).getDepartment()));
				sheet.addCell(new Label(4,i+1,list.get(i).getImmediateSuperior()));
				sheet.addCell(new Label(5,i+1,list.get(i).getStationCategory()));
				sheet.addCell(new Label(6,i+1,list.get(i).getStationDescription()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	public void ClassesExcel(List<Classes> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://ClassesExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("Classes", 0);
			//创建表头
			String []tableHead={"Id","编码","名称","早上上班时间","下午下班时间","备注"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getCode()));
				sheet.addCell(new Label(2,i+1,list.get(i).getName()));
				sheet.addCell(new Label(3,i+1,list.get(i).getMorningBusinessHours()));
				sheet.addCell(new Label(4,i+1,list.get(i).getAfternoonBusinessHours()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	public void PunchCardExcel(List<PunchCard> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://PunchCardExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("PunchCard", 0);
			//创建表头
			String []tableHead={"ID","打卡人","打卡时间","备注"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getPunchCardMan()));
				sheet.addCell(new Label(2,i+1,list.get(i).getPunchCardDate()));
				sheet.addCell(new Label(3,i+1,list.get(i).getRemark()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	public void RepairCardExcel(List<RepairCard> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://RepairCardExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("RepairCard", 0);
			//创建表头
			String []tableHead={"Id","补卡人","补卡日期","补卡原因"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getRepairCradMan()));
				sheet.addCell(new Label(2,i+1,list.get(i).getRepairCradDate()));
				sheet.addCell(new Label(3,i+1,list.get(i).getRepairCradReason()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	public void PaySalaryExcel(List<PaySalary> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://PaySalaryExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("PaySalary", 0);
			//创建表头
			String []tableHead={"Id","领薪人","薪水","计算开始日期","计算结束日期"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getSalariedMan()));
				sheet.addCell(new Label(2,i+1,list.get(i).getSalary()));
				sheet.addCell(new Label(3,i+1,list.get(i).getCalculateStartDate()));
				sheet.addCell(new Label(4,i+1,list.get(i).getCalculateEndDate()));
				sheet.addCell(new Label(5,i+1,list.get(i).getPaidTime()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	
	public void LeaveExcel(List<Leave> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://LeaveExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("Leave", 0);
			//创建表头
			String []tableHead={"Id","请假人","开始时间","结束时间","请假原因"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getPleaseDummyMan()));
				sheet.addCell(new Label(2,i+1,list.get(i).getStartTime()));
				sheet.addCell(new Label(3,i+1,list.get(i).getEndTime()));
				sheet.addCell(new Label(4,i+1,list.get(i).getLeaveReason()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
	
	public void CheckReportExcel(List<PunchCard> list) throws Exception {
		WritableWorkbook book=null;
		try{
			//默认在f盘下创建一个名字为“excel.xls”的空表,也可以根据需求更改路径名
			File file=new File("f://CheckReportExcel.xls");
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			book =Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("CheckReport", 0);
			//创建表头
			String []tableHead={"Id","员工编码","员工名字","早上打卡时间","下午打卡时间","打卡情况"};
			for(int j=0;j<tableHead.length;j++){
				//获取label对象
				Label label=new Label(j,0,tableHead[j]);
				//sheet将label信息写入单元格
				sheet.addCell(label);
			}
			//将用户集合写入excel
			for(int i=0;i<list.size();i++){
				sheet.addCell(new Label(0,i+1,String.valueOf(list.get(i).getId())));
				sheet.addCell(new Label(1,i+1,list.get(i).getStaffCode()));
				sheet.addCell(new Label(2,i+1,list.get(i).getPunchCardMan()));
				sheet.addCell(new Label(3,i+1,list.get(i).getPunchCardDate()));
				sheet.addCell(new Label(4,i+1,list.get(i).getPunchCardDate_end()));
				sheet.addCell(new Label(5,i+1,list.get(i).getAttendanceSituation()));
			}
			//关闭流
			book.write();
			book.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(RowsExceededException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
}
