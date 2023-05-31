package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class HomeController {

	private final StudentService studentservice;

	public HomeController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}

	@GetMapping("/")
	public String goHome(Model model) {
		List<Student> theStudents = studentservice.getAllStudents();
		model.addAttribute("students", theStudents);
		return "student-home";
	}

	@GetMapping("listStudents")
	public String getAllStudent(Model model) {
		List<Student> theStudents = studentservice.getAllStudents();
		model.addAttribute("students", theStudents);
		return "list-students";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		Student thestudent = new Student();
		model.addAttribute("student", thestudent);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {

		Student student = studentservice.createStudent(theStudent);
		if (student != null) {
			return "student-form-success";
		}
		return "redirect:/";
	}
	
	@GetMapping("/updateStudentFormById")
	public String updateStudentFormById(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "update-student-form-id";
	}
	
	@PostMapping("/updateStudentById")
	public String updateStudentByid(@ModelAttribute("student") Student theStudent,Model model,@RequestParam("id") int studentId) {
		Student student=studentservice.findStudent(studentId);
		if(student == null) {
			theStudent.setId(studentId);
			theStudent.setErrorMessage("\"*** No student found for the given Id:\"");
			return "update-student-form-id";
		}else {
			model.addAttribute("student",student);
			return "student-form";
		}

	}

}
