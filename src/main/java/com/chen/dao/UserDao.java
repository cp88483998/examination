package com.chen.dao;

import java.util.List;

import com.chen.annotation.MyBatisRepository;
import com.chen.entity.User;

@MyBatisRepository
public interface UserDao {
	User findUserByName(String username);
	
	List<User> findAllUser();
}
