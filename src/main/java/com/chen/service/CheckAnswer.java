package com.chen.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.SubjectDao;
import com.chen.entity.Answer;
import com.chen.entity.Subject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public class CheckAnswer {
	
	@Autowired
	SubjectDao dao;
	
	/*
	 * 检查用户答题结果
	 */
	public String check(String answer){
		//先从数据库中找出所有题目
		List<Subject> list = dao.findAllSubject();
		//将用户的答案转换为jsonobject格式
		JSONObject jo = JSONObject.fromObject(answer);
		JSONArray ja = new JSONArray();
		
		//遍历jsonObject，将判断结果记录到一个jsonArray里
		Iterator<String> iter = jo.keys();
		int rightNum = 0;//回答正确数量
		int totalNum = list.size();//总共题目数量
		int anNum = jo.size();//总共答题数量
		for(Subject s : list){
			System.out.println("开始遍历");
			Answer a = new Answer();
			a.setTitle_id(s.getTitle_id());
			a.setRightAnswer(s.getAnswer());
			a.setInterpret(s.getInterpret());
			while(iter.hasNext()){
				String key = iter.next();
				if((s.getTitle_id()+"").equals(key)){
					a.setUserAnswer(jo.getString(key));
					if(s.getAnswer().equals(jo.getString(key))){
						a.setRight(true);
						rightNum ++;
					}
					break;
				}
			}
			ja.add(a);
		}
		
		JSONObject joTotal = new JSONObject();
		joTotal.put("rightNum", rightNum);
		joTotal.put("totalNum", totalNum);
		joTotal.put("anNum", anNum);
		joTotal.put("result", ja);
		return joTotal.toString();
		
	}
}
