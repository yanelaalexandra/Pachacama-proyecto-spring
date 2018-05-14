package com.pachacama.gestion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pachacama.gestion.exception.DAOException;
import com.pachacama.gestion.exception.LoginException;
import com.pachacama.gestion.model.Employee;
import com.pachacama.gestion.services.SecurityService;


/**
 *  Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SecurityService securityService;

/*	
	@GetMapping("/")
	public String menu() {

		return "/login";
	}
*/
	
	//@GetMapping("/login")
	@GetMapping(value={"/", "login"})
	public ModelAndView preLogin() {
		Employee emp = new Employee();
		return new ModelAndView("login", "command", emp);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {

		
		logger.info("login()");
		logger.info(employee.toString());

		ModelAndView modelAndView = null;

		try {
			Employee emp = securityService.validate(employee.getLogin(), employee.getPassword());
			logger.info(emp.toString());
			modelAndView = new ModelAndView("redirect:/admin/menu", "command", emp);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("login", "command", new Employee());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("login", "command", new Employee());
		}

		return modelAndView;
	}
	
	

}
