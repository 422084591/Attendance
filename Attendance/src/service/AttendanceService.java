package service;

import model.Admin;

public interface AttendanceService {
	public Admin getAdminByUP(String username,String password);
	public boolean loginByUP(String username,String password);
	public boolean isExit(String username);
}
