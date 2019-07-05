package service;

import java.util.List;

import dao.ClassesDaoImpl;
import model.Classes;

public class ClassesServiceImpl implements ClassesService<Classes> {
	ClassesDaoImpl dao=new ClassesDaoImpl();
	@Override
	public boolean addClasses(Classes t) {
		// TODO Auto-generated method stub
		return dao.addClasses(t);
	}

	@Override
	public boolean removeClassesByIds(int[] ids) {
		// TODO Auto-generated method stub
		return dao.removeClassesByIds(ids);
	}

	@Override
	public boolean deleteClassesById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteClassesById(id);
	}

	@Override
	public boolean updateClassesById(int id, Classes t) {
		// TODO Auto-generated method stub
		return dao.updateClassesById(id, t);
	}

	@Override
	public Classes getClassesById(int id) {
		// TODO Auto-generated method stub
		return dao.getClassesById(id);
	}

	@Override
	public List<Classes> getClassesByName(String name) {
		// TODO Auto-generated method stub
		return dao.getClassesByName(name);
	}

	@Override
	public List<Classes> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<Classes> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
