package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.PersonDao;
import com.lti.model.Person;

@Service("service")
@Scope(scopeName = "singleton")
public class PersonServiceImpl implements PersonService {

	// StudentDaoImpl dao = new StudentDaoImpl();
	// StudentDao dao = new StudentDaoImpl();

	// Object will be created by Spring Framework & Will be Injected
	@Autowired
	private PersonDao dao = null;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addPerson(Person person) {

		int res = dao.createPerson(person);

		return (res >= 1) ? true : false;
	}

	@Override
	public List<Person> findAllPersons() {

		return dao.readAllPersons();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean modifyPerson(Person person) {

		Person result = dao.updatePerson(person);

		return (result != null) ? true : false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean removePerson(int personId) {
		
		int result = dao.deletePerson(personId);

		return (result == 1) ? true : false;
	}

	@Override
	public Person findPersonbyId(int personId) {
		
		return dao.readPersonbyId(personId);
	}

}
