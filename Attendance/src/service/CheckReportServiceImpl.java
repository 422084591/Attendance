package service;

import java.util.List;

import dao.CheckReportDaoImpl;
import model.PunchCard;


public class CheckReportServiceImpl implements CheckReportService<PunchCard>{
	CheckReportDaoImpl dao=new CheckReportDaoImpl();

	@Override
	public List<PunchCard> getCheckReportByName(String name) {// 通过考勤表中的名字查找考勤表
		// TODO Auto-generated method stub
		return dao.getCheckReportByName(name);
	}

	@Override
	public List<PunchCard> getAllByLimit(int limitNumber) {// 每页找出的考勤记录数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage(int length) {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage(length);
	}

	@Override
	public List<PunchCard> getAll() {//获取全部对象
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public void add(PunchCard punchCard) {//添加一条记录
		// TODO Auto-generated method stub
		dao.add(punchCard);
	}

	@Override
	public void remove() {//批量删除
		// TODO Auto-generated method stub
		dao.remove();
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<PunchCard> getAllFromCheckReport() {// 从checkReport中取得数据
		// TODO Auto-generated method stub
		return dao.getAllFromCheckReport();
	}


	

}
