package service;

import java.util.List;

import dao.RepairCardDaoImpl;
import model.RepairCard;

public class RepairCardServiceImpl implements RepairCardService<RepairCard> {
	RepairCardDaoImpl dao=new RepairCardDaoImpl();
	@Override
	public boolean addRepairCard(RepairCard repairCard) {
		// TODO Auto-generated method stub
		return dao.addRepairCard(repairCard);
	}

	@Override
	public boolean removeRepairCardByIds(int[] ids) {
		// TODO Auto-generated method stub
		return dao.removeRepairCardByIds(ids);
	}

	@Override
	public boolean deleteRepairCardById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteRepairCardById(id);
	}

	@Override
	public boolean updateRepairCardById(int id, RepairCard t) {
		// TODO Auto-generated method stub
		return dao.updateRepairCardById(id, t);
	}

	@Override
	public RepairCard getRepairCardById(int id) {
		// TODO Auto-generated method stub
		return dao.getRepairCardById(id);
	}

	@Override
	public List<RepairCard> getRepairCardByrepairCradMan(String repairCradMan) {
		// TODO Auto-generated method stub
		return dao.getRepairCardByrepairCradMan(repairCradMan);
	}

	@Override
	public List<RepairCard> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<RepairCard> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
