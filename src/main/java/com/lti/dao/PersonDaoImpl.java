package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Person;

@Repository("dao")
public class PersonDaoImpl implements PersonDao{

	@PersistenceContext
	private EntityManager entitymanager;
	
	public PersonDaoImpl() {
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int createPerson(Person person) {
		entitymanager.persist(person);
		return person.getId();
	}

	@Override
	public List<Person> readAllPersons() {
		
		String jpql = "Select p from Person p";
		TypedQuery<Person> tquery = entitymanager.createQuery(jpql,Person.class);
		return tquery.getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Person updatePerson(Person person) {
		
		person = entitymanager.merge(person);
		return person;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deletePerson(int personId) {
		
		Person person = entitymanager.find(Person.class, personId);
		entitymanager.remove(person);
		return 1;
	}

	@Override
	public Person readPersonbyId(int personId) {
		Person person = entitymanager.find(Person.class, personId);
		return person;
	}

	

}
