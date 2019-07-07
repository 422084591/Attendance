package service;

import java.util.List;

import dao.RepairCardDaoImpl;
import model.RepairCard;

public class RepairCardServiceImpl implements RepairCardService<RepairCard> {
	RepairCardDaoImpl dao=new RepairCardDaoImpl();
	@Override
	public boolean addRepairCard(RepairCard repairCard) {// 添加补卡单信息
		// TODO Auto-generated method stub
		return dao.addRepairCard(repairCard);
	}

	@Override
	public boolean removeRepairCardByIds(int[] ids) {// 通过补卡单id数组批量删除员工信息
		// TODO Auto-generated method stub
		return dao.removeRepairCardByIds(ids);
	}

	@Override
	public boolean deleteRepairCardById(int id) {// 通过补卡单id删除补卡单信息
		// TODO Auto-generated method stub
		return dao.deleteRepairCardById(id);
	}

	@Override
	public boolean updateRepairCardById(int id, RepairCard t) {// 通过补卡单的id修改补卡单的信息
		// TODO Auto-generated method stub
		return dao.updateRepairCardById(id, t);
	}

	@Override
	public RepairCard getRepairCardById(int id) {// 通过补卡单id来找补卡单信息
		// TODO Auto-generated method stub
		return dao.getRepairCardById(id);
	}

	@Override
	public List<RepairCard> getRepairCardByrepairCradMan(String repairCradMan) {// 通过补卡人名字查找补卡单
		// TODO Auto-generated method stub
		return dao.getRepairCardByrepairCradMan(repairCradMan);
	}

	@Override
	public List<RepairCard> getAllByLimit(int limitNumber) {// 每页找出的补卡记录数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<RepairCard> getAll() {// 获取全部记录
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
