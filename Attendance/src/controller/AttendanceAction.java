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

public class AttendanceAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AttendanceServiceImpl service = new AttendanceServiceImpl();
	// 模型调用
	private boolean Exit; // 判断是否存在
	private String username; // 用户名
	private String password;// 密码
	private boolean Login;// 登录状态
	private Admin admin;// 登录对象
	private String password2;//确认密码
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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
		admin = service.getAdminByUP(username, password); // 取得查询的admin对象，没有则为空
		/* 如果admin的名字不为空，则存入session，为空则返回错误信息给login.jsp */
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession(); // 取得session对象，把admin存进去
//		System.out.println("action:"+admin.getUsername()+"对象地址"+admin);							//调试
		if (admin.getUsername() != null) {
		if(!admin.getUsername().equals("Admin")) {
				session.setAttribute("User", admin);
				return "loginSuccessAdmin";
			}else {
				session.setAttribute("User", admin);
				return "loginSuccess";
			}

		}
		else {
			request.setAttribute("error", "<font color='red'>用户名或者密码错误</font>");
		}
		return "loginFalse";

	}

	public void ajax() {
		Exit = service.isExit(username);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().append("{\"isSuccess\":" + Exit + "}"); // 返回给ajax的值，json格式
//			System.out.println(Exit);									//调试有没有收到ajax请求
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String  changePassword() {
		HttpServletRequest request=ServletActionContext.getRequest();
		if(password.equals(password2)) {
			service.changePassword(username,password);
			if(username.equals("Admin")) {
				return "changeSuccess";
			}else {
				return "changeSuccessNo";
			}
		}else {
			request.setAttribute("error", "<font color='red'>密码不一致，请重新输入</font>");
			return "changeFaile";
		}
	}

}
