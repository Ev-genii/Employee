package com.test.employeeDirectory.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.employeeDirectory.domain.Employee;
import com.test.employeeDirectory.repos.EmployeeRepository;

@Controller
public class MainController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Value("$(upload.path)")
	private String uploadPath;
	
	@GetMapping("/")
	public String main(
			@RequestParam (required = false, defaultValue = "") String filter, 
			Model model,
			@PageableDefault(sort = {"surname"},  direction = Sort.Direction.ASC) Pageable pageable
	) {
		Page<Employee> page;
	
		if (filter != null && !filter.isEmpty()) {
			page  = employeeRepository.findBySurnameContainingIgnoreCase(filter, pageable);
		} else {
			page = employeeRepository.findAll(pageable);
		}
		
		model.addAttribute("page", page);
		model.addAttribute("filter", filter);
		
		return "main";
	}
	
	@GetMapping("/employee/add")
	public String addEmployee(Model model) {
		return "employeeAdd";
	}
	
	@PostMapping("/employee/add")
	public String addEmployee(
			@Valid Employee employee,
			BindingResult bindingResult,
			Model model,
			@RequestParam("file") MultipartFile file
		) throws IllegalStateException, IOException {
					
			if (bindingResult.hasErrors()) {								
				Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
			
				model.mergeAttributes(errorsMap);
				model.addAttribute("employee", employee);
		
			} else {
		
				saveFile(employee, file);		
				
				model.addAttribute("employee", null);
				 
				employeeRepository.save(employee);
			}
				
			Iterable<Employee> employees = employeeRepository.findAll();
			
			model.addAttribute("employees", employees);
			
			return "employeeAdd";
	}
	
	private void saveFile(@Valid Employee employee, @RequestParam("file") MultipartFile file) throws IOException {
		if (file != null && !file.getOriginalFilename().isEmpty()) {
		    File uploadDir = new File(uploadPath);
		
		     if (!uploadDir.exists()) {
		         uploadDir.mkdir();
		     }
		
		     String uuidFile = UUID.randomUUID().toString();
		     String resultFilename = uuidFile + "." + file.getOriginalFilename();
		
		     file.transferTo(new File(uploadPath + "/" + resultFilename));
				
		     employee.setFilename(resultFilename);
		}
	}
		

	@GetMapping("/employee/{id}")
	public String editEmployee(
			Model model,
			@RequestParam(required = false) Employee employee
			
	) {
		model.addAttribute("employee", employee);
		   
		return "employeeEdit";
	}
	
	@PostMapping("/employee/{id}")
	public String editEmployee(
			@RequestParam("id") Employee employee,
			@RequestParam("surname") String surname,
			@RequestParam("name") String name,
			@RequestParam("lastName") String lastName,
			@RequestParam("position") String position,
			@RequestParam("dateOfBirth") String dateOfBirth,
			@RequestParam("mobilePhone") String mobilePhone,
			@RequestParam("email") String email,
			@RequestParam("file") MultipartFile file 
	
	) throws IOException {
	 
		     if (!StringUtils.isEmpty(surname)) {
		         employee.setSurname(surname);
		     }
		
		     if (!StringUtils.isEmpty(name)) {
		    	 employee.setName(name);
		     }
		     
		     if (!StringUtils.isEmpty(lastName)) {
		    	 employee.setLastName(lastName);
		     }
		     
		     if (!StringUtils.isEmpty(position)) {
		         employee.setPosition(position);
		     }
		     
		     if (!StringUtils.isEmpty(dateOfBirth)) {
		         employee.setDateOfBirth(dateOfBirth);
		     }
		
		     if (!StringUtils.isEmpty(mobilePhone)) {
	    	         employee.setMobilePhone(mobilePhone);
		     }
		     
		     if (!StringUtils.isEmpty(email)) {
		         employee.setEmail(email);
		     }   
			
		     saveFile(employee, file);
		
		     employeeRepository.save(employee);
		
		return "redirect:/";
	}
	
	@PostMapping("/employee/{id}/remove")
	public String employeeDelete(@PathVariable(value = "id") long id, Model model 
			
	) {
		Employee employee = employeeRepository.findById(id).orElseThrow(null);
		employeeRepository.delete(employee);
		
		return "redirect:/";
	}
	
}
