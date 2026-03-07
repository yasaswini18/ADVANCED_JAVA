package com.mvc.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.demo.Model.Student;
import com.mvc.demo.Repository.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public void saveStudent(Student student)
	{
		studentDao.save(student);
	}
}
