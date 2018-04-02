package com.qhit.lh.gr3.merida.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.gr3.merida.exam.common.bean.User;
import com.qhit.lh.gr3.merida.exam.common.utils.Constans;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("µÇÂ¼Ð£ÑéÀ¹½ØÆ÷Ö´ÐÐ");
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null){
			//Î´µÇÂ¼
			return Constans.VIEW_LOGIN;
		}
		return arg0.invoke();
	}

}
