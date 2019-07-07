package service;

import java.util.List;

import dao.PaySalaryDaoImpl;
import model.PaySalary;

public class PaySalaryServiceImpl implements PaySalaryService<PaySalary>{
	PaySalaryDaoImpl dao=new PaySalaryDaoImpl();
	@Override
	public boolean addPaySalary(PaySalary paySalary) {// 添加打卡单信息
		// TODO Auto-generated method stub
		return dao.addPaySalary(paySalary);
	}

	@Override
	public boolean removePaySalaryByIds(int[] ids) {// 通过打卡单id数组批量删除员工信息
		// TODO Auto-generated method stub
		return dao.removePaySalaryByIds(ids);
	}

	@Override
	public boolean deletePaySalaryById(int id) {// 通过打卡单id删除打卡单信息
		// TODO Auto-generated method stub
		return dao.deletePaySalaryById(id);
	}

	@Override
	public boolean updatePaySalaryById(int id, PaySalary paySalary) {// 通过打卡单的id修改打卡单的信息
		// TODO Auto-generated method stub
		return dao.updatePaySalaryById(id, paySalary);
	}

	@Override
	public PaySalary getPaySalaryById(int id) {// 通过打卡单id来找打卡单信息
		// TODO Auto-generated method stub
		return dao.getPaySalaryById(id);
	}

	@Override
	public List<PaySalary> getPaySalaryBySalariedMan(String SalariedMan) {// 通过打卡人名字查找打卡单
		// TODO Auto-generated method stub
		return dao.getPaySalaryBySalariedMan(SalariedMan);
	}

	@Override
	public List<PaySalary> getAllByLimit(int limitNumber) {// 每页找出的打卡记录数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<PaySalary> getAll() {// 获取所有打卡信息
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
