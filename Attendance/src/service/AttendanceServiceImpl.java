package service;

import dao.AttendanceDaoImpl;
import model.Admin;

public class AttendanceServiceImpl implements AttendanceService{
	AttendanceDaoImpl dao=new AttendanceDaoImpl();

	@Override
	public Admin getAdminByUP(String username, String password) {
		// TODO Auto-generated method stub
		return dao.getAdminByUP(username, password);
	}

	@Override
	public boolean loginByUP(String username, String password) {
		// TODO Auto-generated method stub
		return dao.loginByUP(username, password);
	}

	@Override
	public boolean isExit(String username) {
		// TODO Auto-generated method stub
		return dao.isExit(username);
	}


	
}
