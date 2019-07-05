package service;

import java.util.List;

import dao.CheckReportDaoImpl;
import model.PunchCard;


public class CheckReportServiceImpl implements CheckReportService<PunchCard>{
	CheckReportDaoImpl dao=new CheckReportDaoImpl();

	@Override
	public List<PunchCard> getCheckReportByName(String name) {
		// TODO Auto-generated method stub
		return dao.getCheckReportByName(name);
	}

	@Override
	public List<PunchCard> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage(int length) {
		// TODO Auto-generated method stub
		return dao.getMaxPage(length);
	}

	@Override
	public List<PunchCard> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public void add(PunchCard punchCard) {
		// TODO Auto-generated method stub
		dao.add(punchCard);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		dao.remove();
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<PunchCard> getAllFromCheckReport() {
		// TODO Auto-generated method stub
		return dao.getAllFromCheckReport();
	}


	

}
