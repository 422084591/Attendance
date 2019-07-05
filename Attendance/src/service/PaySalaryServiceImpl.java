package service;

import java.util.List;

import dao.PaySalaryDaoImpl;
import model.PaySalary;

public class PaySalaryServiceImpl implements PaySalaryService<PaySalary>{
	PaySalaryDaoImpl dao=new PaySalaryDaoImpl();
	@Override
	public boolean addPaySalary(PaySalary paySalary) {
		// TODO Auto-generated method stub
		return dao.addPaySalary(paySalary);
	}

	@Override
	public boolean removePaySalaryByIds(int[] ids) {
		// TODO Auto-generated method stub
		return dao.removePaySalaryByIds(ids);
	}

	@Override
	public boolean deletePaySalaryById(int id) {
		// TODO Auto-generated method stub
		return dao.deletePaySalaryById(id);
	}

	@Override
	public boolean updatePaySalaryById(int id, PaySalary paySalary) {
		// TODO Auto-generated method stub
		return dao.updatePaySalaryById(id, paySalary);
	}

	@Override
	public PaySalary getPaySalaryById(int id) {
		// TODO Auto-generated method stub
		return dao.getPaySalaryById(id);
	}

	@Override
	public List<PaySalary> getPaySalaryBySalariedMan(String SalariedMan) {
		// TODO Auto-generated method stub
		return dao.getPaySalaryBySalariedMan(SalariedMan);
	}

	@Override
	public List<PaySalary> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<PaySalary> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
