package com.chen.dao;

import java.util.List;

import com.chen.annotation.MyBatisRepository;
import com.chen.entity.Subject;

@MyBatisRepository
public interface SubjectDao {
	List<Subject> findAllSubject();
}
