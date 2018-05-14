package com.pachacama.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pachacama.gestion.dao.EmployeeDAO;
import com.pachacama.gestion.exception.DAOException;
import com.pachacama.gestion.exception.LoginException;
import com.pachacama.gestion.model.Employee;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee validate(String login, String password) throws LoginException, DAOException {

		Employee emp = employeeDAO.validate(login, password);

		return emp;
	}

}
