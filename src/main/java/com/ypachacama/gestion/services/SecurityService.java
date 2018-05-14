package com.ypachacama.gestion.services;

import com.ypachacama.gestion.exception.DAOException;
import com.ypachacama.gestion.exception.LoginException;
import com.ypachacama.gestion.model.Employee;

public interface SecurityService {

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
