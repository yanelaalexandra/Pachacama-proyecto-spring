package com.pachacama.gestion.dao;

import java.util.List;

import com.pachacama.gestion.exception.DAOException;
import com.pachacama.gestion.exception.EmptyResultException;
import com.pachacama.gestion.exception.LoginException;
import com.pachacama.gestion.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;

	void create(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	void delete(String login) throws DAOException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException;

	List<Employee> findAllEmployees() throws DAOException, EmptyResultException;

	List<Employee> findEmployeesByName(String name) throws DAOException, EmptyResultException;

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
