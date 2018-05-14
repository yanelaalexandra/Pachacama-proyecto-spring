package com.ypachacama.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.ypachacama.gestion.exception.DAOException;
import com.ypachacama.gestion.exception.EmptyResultException;
import com.ypachacama.gestion.model.Department;
import com.ypachacama.gestion.dao.DepartmentDAO;
import com.ypachacama.gestion.dao.DepartmentDAOTest;

public class DepartmentDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOTest.class);

	@Autowired
	private DepartmentDAO departmentDAO;

	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	@Test
	public void testFindDepartmentbyId() {

		try {
			//
			Department department = departmentDAO.findDepartment(47);

			Assert.assertNotNull(department);
			
			Assert.assertEquals("gomez", department.getName());
			Assert.assertEquals("profesor", department.getDescription());
			Assert.assertEquals("santa anita", department.getCity());
			
			logger.info(department.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testFindAllDepartments() {

		try {
			//
			List<Department> departments = departmentDAO.findAllDepartments();

			logger.info(departments.toString());

			} catch (EmptyResultException e) {
				fail(e.getMessage());
			} catch (DAOException e) {
				fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreateDepartment() {

		logger.info("--");	
		String name = "Yanela" + (int) (Math.random() * 100);;
		String description = "Alumna de Tecsup";
		String city = "Lima";

		try {

			departmentDAO.create(name, description, city);

			Department department = departmentDAO.findDepartmentByName(name);
	
			Assert.assertEquals(name, department.getName());
			Assert.assertEquals(description, department.getDescription());
			Assert.assertEquals(city, department.getCity());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testUpdateDepartment() {

		String name = "Yanela" + (int) (Math.random() * 100);;
		String description = "Alumna de Tecsup";
		String city = "Lima";
				
		String UP_description = "Profesional";
		String UP_city = "Ica";
		
		
		try {
			departmentDAO.create(name, description, city);
					
			departmentDAO.update(name, UP_description, UP_city);
			
			Department department= departmentDAO.findDepartmentByName(name);
					
			Assert.assertEquals(UP_description, department.getDescription());
			Assert.assertEquals(UP_city, department.getCity());	
			
			} catch (DAOException e) {
				fail(e.getMessage());
			} catch (EmptyResultException e) {
				fail(e.getMessage());
		}

	}
	
	@Test
	public void testDeleteDepartment() {
		String name = "Yanela" + (int) (Math.random() * 100);;
		String description = "Alumna";
		String city = "Chorrillos";

		try {
			departmentDAO.create(name, description, city);
	
		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {
			
			departmentDAO.delete(name);
			
			departmentDAO.findDepartmentByName(name);
			
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (EmptyResultException e) {
			return;
		}

	}

}
