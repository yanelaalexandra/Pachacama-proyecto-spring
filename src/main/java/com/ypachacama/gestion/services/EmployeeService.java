package com.ypachacama.gestion.services;

import java.util.List;

import com.ypachacama.gestion.exception.DAOException;
import com.ypachacama.gestion.exception.EmptyResultException;
import com.ypachacama.gestion.model.Employee;

public interface EmployeeService {

	Employee find(int employee_id) throws DAOException, EmptyResultException;

	List<Employee> findAll() throws DAOException, EmptyResultException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException;
}
