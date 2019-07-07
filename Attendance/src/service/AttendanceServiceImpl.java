package service;

import dao.AttendanceDaoImpl;
import model.Admin;

public class AttendanceServiceImpl implements AttendanceService{
	AttendanceDaoImpl dao=new AttendanceDaoImpl();

	@Override
	public Admin getAdminByUP(String username, String password) {// 通过账号密码查询是否存在该管理员
		// TODO Auto-generated method stub
		return dao.getAdminByUP(username, password);
	}

	@Override
	public boolean loginByUP(String username, String password) {// 通过账号密码查询登录是否成功
		// TODO Auto-generated method stub
		return dao.loginByUP(username, password);
	}

	@Override
	public boolean isExit(String username) {// 通过账号查询该账户是否存在
		// TODO Auto-generated method stub
		return dao.isExit(username);
	}


	
}
