package util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import model.Admin;

public class AdminInterceptor  extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		 Admin u = (Admin) ActionContext.getContext().getSession().get("User");//判断登录用户是否是管理员，如果不是，将无法使用部分功能
	        if (u==null) {
	            return "fail";
	        }else if(!u.getUsername().equals("Admin")) {
	        	return "noAdmin";
	        }
	        return invocation.invoke();
	}


}
