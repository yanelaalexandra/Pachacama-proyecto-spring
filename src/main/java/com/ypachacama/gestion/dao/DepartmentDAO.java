package com.ypachacama.gestion.dao;

import java.util.List;

import com.ypachacama.gestion.exception.DAOException;
import com.ypachacama.gestion.exception.EmptyResultException;
import com.ypachacama.gestion.model.Department;


public interface DepartmentDAO {
	
	Department findDepartment(int id) throws DAOException, EmptyResultException;
	
	List<Department> findAllDepartments() throws DAOException, EmptyResultException;
	
	Department findDepartmentByName(String name) throws DAOException, EmptyResultException;
	
	void create(String name, String description, String city) throws DAOException;

	void delete(String name) throws DAOException;

	void update(String name, String description, String city) throws DAOException;

	

}
