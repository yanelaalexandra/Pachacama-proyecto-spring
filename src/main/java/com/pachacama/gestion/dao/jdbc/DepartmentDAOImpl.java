package com.pachacama.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pachacama.gestion.dao.DepartmentDAO;
import com.pachacama.gestion.dao.jdbc.DepartmentDAOImpl;
import com.pachacama.gestion.exception.DAOException;
import com.pachacama.gestion.exception.EmptyResultException;
import com.pachacama.gestion.mapper.DepartmentMapper;
import com.pachacama.gestion.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public Department findDepartment(int id) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		String query = "SELECT department_id, name, description, city"
				+ " FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { id };
	
		try {
	
			Department  department = (Department) jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return department;
			//return null;
	
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Department> findAllDepartments() throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		String query = "SELECT department_id, name, description, city FROM departments";
		try {
			List<Department> departments = jdbcTemplate.query(query, new DepartmentMapper());

			return departments;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
			
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Department findDepartmentByName(String name) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		String query = "SELECT department_id, name, description, city"
				        + " FROM departments WHERE name = ? ";

			Object[] params = new Object[] { name };
		
			try {
		
				Department department = jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
				return department;
		
			} catch (EmptyResultDataAccessException e) {
				throw new EmptyResultException();
			} catch (Exception e) {
				logger.info("Error: " + e.getMessage());
				throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String name, String description, String city) throws DAOException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO departments (name, description, city)  VALUES ( ?,?,? )";
		Object[] params = new Object[] { name, description, city };
		
		Department department = null;
		
		try {
			jdbcTemplate.update(query, params);
			
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String name) throws DAOException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM  departments WHERE name = ? ";

		Object[] params = new Object[] { name };

		try {
			jdbcTemplate.update(query, params);
			
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
			}
		
	}

	@Override
	public void update(String name, String description, String city) throws DAOException {
		// TODO Auto-generated method stub
		String query = "UPDATE departments SET description =?, city = ? WHERE name = ?";
		Object[] params = new Object[] {description, city, name};

		try {
			jdbcTemplate.update(query, params);
			
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

}
