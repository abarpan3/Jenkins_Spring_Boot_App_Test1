package com.lti.service;

import java.util.List;

import com.lti.model.Person;

public interface PersonService {
	
	public boolean addPerson(Person person);

	public List<Person> findAllPersons();

	public boolean modifyPerson(Person person);

	public boolean removePerson(int personId);
	
	public Person findPersonbyId(int personId);
}
