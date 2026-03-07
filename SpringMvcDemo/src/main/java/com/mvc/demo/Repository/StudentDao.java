package com.mvc.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.demo.Model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student,Long>{

	
}
