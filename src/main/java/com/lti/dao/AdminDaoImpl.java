package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Login;

@Repository("logindao")
public class AdminDaoImpl {
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public boolean loginStatus(Login login) {
		
		String jpql = "Select l from Login l where l.ademail = :email ";
		Query query = entitymanager.createQuery(jpql,Login.class).setParameter("email", login.getAdemail());
		
		Login verify ;
		try {
			verify = (Login) query.getSingleResult();

		}
		catch(Exception e) {
			return false;
		}
		
		if (verify.getAdpass().equals(login.getAdpass())) {
			
			return true;
		}
		else {
			return false;
		}
	}
}
