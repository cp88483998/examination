package com.chen.web;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.entity.Subject;
import com.chen.entity.User;
import com.chen.myException.NameOrPwdException;
import com.chen.service.CheckAnswer;
import com.chen.service.SubjectListService;
import com.chen.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/online-test")
public class MyController {
	
	@Resource(name="subjectListService")
	SubjectListService listService;
	@Resource(name="checkAnswer")
	CheckAnswer checkService;
	@Resource(name="userService")
	UserService userService;
	
	/*
	 * 异常处理 
	 */
	@ExceptionHandler
	public String ExecutionException(HttpServletRequest req, HttpServletResponse res, Exception e) 
			throws Exception{
		if(e instanceof NameOrPwdException){
			req.setAttribute("message", e.getMessage());
			req.setAttribute("username", req.getParameter("username"));
			return "../index";
		}else{
			throw e;
		}
	}
	@RequestMapping("/login.do")
	public String login(){
		System.out.println("login");
		return "../index";
	}
	
	@RequestMapping("/visitorLogin.do")
	public String visitorLogin(HttpSession session){
		List<User> list = userService.findAllUser();
		Random ran = new Random();
		int n = ran.nextInt(list.size());
		User user = list.get(n);
		session.setAttribute("user", user);
		
		return "redirect:subjectList.html";
	}
	
	@RequestMapping("/checkLogin.do")
	public String checkLogin(HttpServletRequest req, HttpServletResponse res, HttpSession session){
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		User user = userService.findUserByName(username, password);
		session.setAttribute("user", user);
		return "redirect:subjectList.html";
	}
	
	@RequestMapping("/subjectList.do")
	public String subjectList(ModelMap map){
		System.out.println("subjectList.do");
		List<Subject> list = listService.findAllSubject();
		map.addAttribute("subjects", list);
		return "list";
	}
	
	@RequestMapping("/checkAnswer.do")
	public void checkAnswer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String answer = req.getParameter("str");
		System.out.println("userAn:"+answer);
		
		String msg = checkService.check(answer);
		
		JSONObject jo = new JSONObject();
		jo.put("msg", msg);
		res.setContentType("text/html; charset=UTF-8"); 
		res.getWriter().println(jo.toString());
	}
	
	@RequestMapping("/error.do")
	public String error(){
		return "../error";
	}
}
