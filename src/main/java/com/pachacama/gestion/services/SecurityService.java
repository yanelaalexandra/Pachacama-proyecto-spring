package com.pachacama.gestion.services;

import com.pachacama.gestion.exception.DAOException;
import com.pachacama.gestion.exception.LoginException;
import com.pachacama.gestion.model.Employee;

public interface SecurityService {

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
