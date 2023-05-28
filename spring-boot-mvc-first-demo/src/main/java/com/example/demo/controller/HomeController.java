package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Controller
public class HomeController {

	private CustomerDao customerdao;

	public HomeController(CustomerDao customerdao) {
		super();
		this.customerdao = customerdao;
	}

	@GetMapping
	public String sayHello() {

		return "index";
	}

	@GetMapping("/list")
	public String customerHome(Model model) {

		List<Customer> customers = customerdao.getAllCustomer();
		model.addAttribute("c", customers);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormtoAdd(Model model) {
		Customer thecustomer = new Customer();
		model.addAttribute("customer", thecustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerdao.createCustomer(customer);
		return "redirect:/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
	Customer theCustomer = customerdao.getCustomerById(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerdao.deleteCustomer(theId);
		return "redirect:/";
	}

}
