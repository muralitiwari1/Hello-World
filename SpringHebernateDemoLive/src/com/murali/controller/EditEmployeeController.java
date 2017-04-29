package com.murali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.murali.entity.EmployeeEntity;
import com.murali.service.EmployeeService;
/*
 * author: murali.com
 * 
 */
 
@Controller
public class EditEmployeeController {
	 @Autowired
	    private EmployeeService employeeService;
	 
		@RequestMapping("/")
		public ModelAndView helloWorld() {
	 
			String message = "<br><div style='text-align:center;'>"
					+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
			return new ModelAndView("welcome", "message", message);
		}
		
	    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	    public String listEmployees(ModelMap map)
	    {
	        map.addAttribute("employee", new EmployeeEntity());
	        map.addAttribute("employeeList", employeeService.getAllEmployees());
	        return "editEmployeeList";
	    }
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, BindingResult result)
	    {
	        employeeService.addEmployee(employee);
	        return "redirect:/";
	    }
	    @RequestMapping("/delete/{employeeId}")
	    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
	    {
	        employeeService.deleteEmployee(employeeId);
	        return "redirect:/";
	    }
	    public void setEmployeeManager(EmployeeService employeeManager) {
	        this.employeeService = employeeManager;
	    }
}
