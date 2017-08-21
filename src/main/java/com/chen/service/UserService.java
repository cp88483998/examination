package com.chen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.UserDao;
import com.chen.entity.User;
import com.chen.myException.NameOrPwdException;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public User findUserByName(String username, String password){
		User user = dao.findUserByName(username);
//		System.out.println(user.toString());
		if(user == null || !user.getPassword().equals(password)){
			throw new NameOrPwdException("用户名或密码错误");
		}else{
			return user;
		}
	}
	
	public List<User> findAllUser(){
		List<User> list = dao.findAllUser();
		return list;
	}
}
