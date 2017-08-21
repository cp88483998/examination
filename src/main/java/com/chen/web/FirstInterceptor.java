package com.chen.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chen.entity.User;

/**
 * 拦截器类:未登录无法访问其他页面
 * <p>Title: FirstInterceptor<／p>
 * <p>Description: <／p>
 * <p>Company: LTGames<／p>	
 * @author 陈鹏
 * @date 2017年8月4日
 */
public class FirstInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("FirstInterceptor");
		User user = (User) req.getSession().getAttribute("user");
		if(user == null){
			System.out.println("sendRedirect");
			res.sendRedirect(req.getContextPath()+"/online-test/login.html");
			return false;
		}
		return true;
	}

}
