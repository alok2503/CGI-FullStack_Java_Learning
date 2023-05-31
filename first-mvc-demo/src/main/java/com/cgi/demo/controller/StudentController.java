package com.cgi.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.demo.model.Student;

@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("student",new Student());
		return "showform";
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/processform")
	public String processForm(@ModelAttribute("student") Student ss,Model theModel) {
		
		theModel.addAttribute("s", ss);
		
		return "processform";
	}

}
