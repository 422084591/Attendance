package service;

import java.util.List;

import dao.PunchCardDao;
import dao.PunchCardDaoImpl;
import model.PunchCard;

public class PunchCardServiceImpl implements PunchCardService<PunchCard>{
	PunchCardDaoImpl dao=new PunchCardDaoImpl();
	@Override
	public boolean addPunchCard(PunchCard punchCard) {
		// TODO Auto-generated method stub
		return dao.addPunchCard(punchCard);
	}

	@Override
	public boolean removePunchCardByIds(int[] ids) {
		// TODO Auto-generated method stub
		return dao.removePunchCardByIds(ids);
	}

	@Override
	public boolean deletePunchCardById(int id) {
		// TODO Auto-generated method stub
		return dao.deletePunchCardById(id);
	}

	@Override
	public boolean updatePunchCardById(int id, PunchCard punchCard) {
		// TODO Auto-generated method stub
		return dao.updatePunchCardById(id, punchCard);
	}

	@Override
	public PunchCard getPunchCardById(int id) {
		// TODO Auto-generated method stub
		return dao.getPunchCardById(id);
	}

	@Override
	public List<PunchCard> getPunchCardByPunchCardMan(String punchCardMan) {
		// TODO Auto-generated method stub
		return dao.getPunchCardByPunchCardMan(punchCardMan);
	}

	@Override
	public List<PunchCard> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<PunchCard> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
