package com.lti.dao;

import java.util.List;

import com.lti.model.Person;

public interface PersonDao {

	public int createPerson(Person person);

	public List<Person> readAllPersons();

	public Person updatePerson(Person person);

	public int deletePerson(int personId);
	
	public Person readPersonbyId(int personId);

}
