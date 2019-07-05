package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Admin;
import service.AttendanceServiceImpl;

public class AttendanceAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AttendanceServiceImpl service=new AttendanceServiceImpl();
	//模型调用
	private boolean Exit;
	private String username;
	private String password;
	private boolean Login;
	private Admin admin;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AttendanceServiceImpl getService() {
		return service;
	}
	public void setService(AttendanceServiceImpl service) {
		this.service = service;
	}
	public boolean isLogin() {
		return Login;
	}
	public void setLogin(boolean login) {
		Login = login;
	}
	public boolean isExit() {
		return Exit;
	}
	public void setExit(boolean exit) {
		Exit = exit;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	/************************************************************************************/
	public String login() {
		admin=service.getAdminByUP(username, password);						//取得查询的admin对象，没有则为空
		/*如果admin的名字不为空，则存入session，为空则返回错误信息给login.jsp */
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();							//取得session对象，把admin存进去
//		System.out.println("action:"+admin.getUsername()+"对象地址"+admin);							//调试
		if(admin.getUsername()!=null) {
			session.setAttribute("User", admin);
			return "loginSuccess";
		}else {
			request.setAttribute("error","<font color='red'>用户名或者密码错误</font>");
		}
		return "loginFalse";	
	
	}
	public void ajax() {
		Exit=service.isExit(username);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		try {
			response.getWriter().append("{\"isSuccess\":"+Exit+"}");	//返回给ajax的值，json格式
//			System.out.println(Exit);									//调试有没有收到ajax请求
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
