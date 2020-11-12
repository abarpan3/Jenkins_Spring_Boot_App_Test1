package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDaoImpl;
import com.lti.model.Login;

@Service("loginService")
@Scope(scopeName = "singleton")
public class LoginServiceImpl {
	
	@Autowired
	private AdminDaoImpl admdao;
	
	public boolean verifyLogin(Login login) {
		
		return admdao.loginStatus(login);
	}
}
