package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.entity.Subject;
import com.chen.service.SubjectListService;

public class SubjectListTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
	
	
	@Test
	public void subjectListTest(){
		SubjectListService service = ac.getBean("subjectListService", SubjectListService.class);
		List<Subject> list = service.findAllSubject();
		System.out.println(list.size());
	}
	
}
