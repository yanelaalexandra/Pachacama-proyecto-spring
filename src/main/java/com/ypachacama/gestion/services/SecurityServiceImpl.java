package com.ypachacama.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypachacama.gestion.dao.EmployeeDAO;
import com.ypachacama.gestion.exception.DAOException;
import com.ypachacama.gestion.exception.LoginException;
import com.ypachacama.gestion.model.Employee;

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
