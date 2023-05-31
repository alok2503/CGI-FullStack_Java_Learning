package com.cgi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String goHome() {
		return "welcome";
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/hello")
	public String goResult(@RequestParam("t1") String str, Model theModel) {
		
		theModel.addAttribute("attr",str);
		return "result";
	}

}
