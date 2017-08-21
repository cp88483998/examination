package com.chen.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.SubjectDao;
import com.chen.entity.Subject;

@Service
public class SubjectListService {
	
	@Resource(name="subjectDao")
	SubjectDao dao;
	
	public List<Subject> findAllSubject(){
		return dao.findAllSubject();
	}
}
