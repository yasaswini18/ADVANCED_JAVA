package com.mvc.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.demo.Model.Student;
import com.mvc.demo.Service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute Student student,Model model)
	{   //@ModelAttribute - binding form data to student object
		//student service - to forward data to dao or repository and then receive the response
		studentService.saveStudent(student);
		
		//Model sends data to JSP view
		model.addAttribute("name", student.getName());
		
		return "Success";//returns view name Success
	}
	
	//get request to display registration form
	@GetMapping("/register")
	public String showForm()
	{
		return "Register";
	}

}
