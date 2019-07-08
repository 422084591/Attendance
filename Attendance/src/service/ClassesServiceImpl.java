package service;

import java.util.List;

import dao.ClassesDaoImpl;
import model.Classes;

public class ClassesServiceImpl implements ClassesService<Classes> {
	ClassesDaoImpl dao=new ClassesDaoImpl();
	@Override
	public boolean addClasses(Classes t) {// 添加打卡单信息
		// TODO Auto-generated method stub
		return dao.addClasses(t);
	}

	@Override
	public boolean removeClassesByIds(int[] ids) {// 通过打卡单id数组批量删除员工信息
		// TODO Auto-generated method stub
		return dao.removeClassesByIds(ids);
	}

	@Override
	public boolean deleteClassesById(int id) { // 通过打卡单id删除打卡单信息
		// TODO Auto-generated method stub
		return dao.deleteClassesById(id);
	}

	@Override
	public boolean updateClassesById(int id, Classes t) {// 通过打卡单的id修改打卡单的信息
		// TODO Auto-generated method stub
		return dao.updateClassesById(id, t);
	}

	@Override
	public Classes getClassesById(int id) {// 通过打卡单id来找打卡单信息
		// TODO Auto-generated method stub
		return dao.getClassesById(id);
	}

	@Override
	public List<Classes> getClassesByName(String name) {// 通过打卡人名字查找打卡单
		// TODO Auto-generated method stub
		return dao.getClassesByName(name);
	}

	@Override
	public List<Classes> getAllByLimit(int limitNumber) {// 每页找出的打卡记录数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<Classes> getAll() {//获取全部数据
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
